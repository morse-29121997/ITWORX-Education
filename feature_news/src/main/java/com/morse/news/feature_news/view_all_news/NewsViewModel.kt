package com.morse.news.feature_news.view_all_news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.map
import com.morse.core.ui_models.Country
import com.morse.core.ui_models.New
import com.morse.core.ui_models.Preference
import com.morse.core.ui_models.Source
import com.morse.datasource.repositories.NewsRepository
import com.morse.domain.repositories.INewsRepository
import com.morse.domain.repositories.ISessionRepository
import com.morse.domain.usecases.news.AddNewsToWatchLaterUseCase
import com.morse.domain.usecases.news.DeleteNewsFromWatchLaterUseCase
import com.morse.domain.usecases.news.GetAllNewsInWatchLaterUseCase
import com.morse.domain.usecases.news.GetAllNewsUseCase
import com.morse.domain.usecases.news.GetHeadlineNewsUseCase
import com.morse.domain.usecases.news.IsExistNewsInWatchLaterUseCase
import com.morse.domain.usecases.onboarding.GetSelectedCountryUseCase
import com.morse.domain.usecases.onboarding.GetSelectedPreferencesUseCase
import com.morse.news.mapper.asDomain
import com.morse.news.mapper.asUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject


data class NewsState(
    val watchLater: List<New> = emptyList(),
    val allSources: List<Source>,
    val currentSource: Source,
    val defaultPreferences: List<Preference>,
    val defaultCountry: Country,
    val allNews: Flow<PagingData<New>>,
    val headlineNews: Flow<PagingData<New>>,
) {
    companion object {
        val Empty = NewsState(
            emptyList(),
            Source.get(),
            Source.get().first(),
            emptyList(),
            Country.get().first(),
            flow {},
            flow {}
        )
    }
}

sealed class NewsEvent {
    data class OnSourceSelected(val source: Source) : NewsEvent()
    data class OnWatchLaterSelected(val new: New, val isAdded: Boolean) : NewsEvent()
}

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val selectedCountryUseCase: GetSelectedCountryUseCase,
    private val selectedPreferencesUseCase: GetSelectedPreferencesUseCase,
    private val allNewsUseCase: GetAllNewsUseCase,
    private val headlineNewsUseCase: GetHeadlineNewsUseCase,
    private val addNewToWatchLaterUseCase: AddNewsToWatchLaterUseCase,
    private val deleteNewFromWatchLaterUseCase: DeleteNewsFromWatchLaterUseCase,
    private val allWatchLaterUseCase: GetAllNewsInWatchLaterUseCase,
) : ViewModel() {
    private val defaultCountry by lazy {
        selectedCountryUseCase(Unit)?.asUi() ?: Country.get().first()
    }
    private val defaultPreference by lazy {
        selectedPreferencesUseCase(Unit)
            .map { it.asUi() } as ArrayList<Preference>? ?: Preference.get()
    }

    var newsState: MutableStateFlow<NewsState> = MutableStateFlow(NewsState.Empty)

    init {
        allWatchLaterUseCase.invoke(Unit).onEach { list ->
            newsState.update {
                it.copy(
                    watchLater = list.map { it.asUi() },
                    allSources = Source.get().apply { first().apply { isSelected.value = true } },
                    currentSource = Source.get().first(),
                    defaultPreferences = defaultPreference,
                    defaultCountry = defaultCountry,
                    allNews = allNewsUseCase.invoke(
                        GetAllNewsUseCase.Companion.Input(
                            null,
                            arrayListOf(Source.get().first().key)
                        )
                    ).map {
                        it.map {
                            it.asUi().apply { isWatchedLater.value = list.count{ it.url == url }  > 0}
                        }
                    },
                    headlineNews = headlineNewsUseCase.invoke(
                        GetHeadlineNewsUseCase.Companion.Input(
                            null,
                            defaultCountry.key,
                            defaultPreference.map { it.key } as ArrayList<String>
                        )
                    ).map {
                        it.map {
                            it.asUi().apply { isWatchedLater.value = list.count{ it.url == url }  > 0}
                        }
                    },
                )
            }

        }.launchIn(viewModelScope)
    }

    private fun update(function: (NewsState) -> NewsState) = newsState.update(function)

    fun onEvent(event: NewsEvent) {
        when (event) {
            is NewsEvent.OnWatchLaterSelected -> {
                if (event.isAdded) {
                    addNewToWatchLaterUseCase.invoke(event.new.asDomain())
                } else {
                    deleteNewFromWatchLaterUseCase.invoke(event.new.asDomain())
                }
                loadAllWatchLater()
            }

            is NewsEvent.OnSourceSelected -> {
                update {
                    it.copy(currentSource = event.source)
                }
                update {
                    val watchLater: List<New> = it.watchLater
                    it.copy(
                        allNews = allNewsUseCase.invoke(
                            GetAllNewsUseCase.Companion.Input(
                                null,
                                arrayListOf(event.source.key)
                            )
                        ).map {
                            it.map {
                             it.asUi().apply { isWatchedLater.value = watchLater.count{ it.url == url }  > 0}
                            }
                        }
                    )
                }
            }
        }
    }

    private fun loadAllWatchLater() {
        allWatchLaterUseCase.invoke(Unit).onEach { list ->
            update { it.copy(watchLater = list.map { it.asUi() }) }
        }.launchIn(viewModelScope)
    }

}