package com.morse.news.feature_news.view_saved_news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.morse.core.ui_models.Country
import com.morse.core.ui_models.New
import com.morse.core.ui_models.Preference
import com.morse.core.ui_models.Source
import com.morse.domain.repositories.INewsRepository
import com.morse.domain.repositories.ISessionRepository
import com.morse.domain.usecases.news.AddNewsToWatchLaterUseCase
import com.morse.domain.usecases.news.DeleteNewsFromWatchLaterUseCase
import com.morse.domain.usecases.news.GetAllNewsInWatchLaterUseCase
import com.morse.news.feature_news.view_all_news.NewsState
import com.morse.news.mapper.asDomain
import com.morse.news.mapper.asUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SavedState(
    val watchLater: List<New> = emptyList(),
) {
    companion object {
        val Empty = SavedState(
            emptyList(),
        )
    }
}

sealed class SavedEvent {
    data object Refresh : SavedEvent()
    data class OnWatchLaterSelected(val new: New, val isAdded: Boolean) : SavedEvent()
}

@HiltViewModel
class SavedViewModel @Inject constructor(
    private val allWatchLaterUseCase: GetAllNewsInWatchLaterUseCase,
    private val addNewToWatchLaterUseCase: AddNewsToWatchLaterUseCase,
    private val deleteNewFromWatchLaterUseCase: DeleteNewsFromWatchLaterUseCase,
) : ViewModel() {

   val savedState: MutableStateFlow<SavedState> = MutableStateFlow(SavedState.Empty)

    init {
        allWatchLaterUseCase.invoke(Unit).onEach { laters ->
            update {
                it.copy(watchLater = laters.map { it.asUi() }
                    .onEach { it.apply { isWatchedLater.value = true } })
            }
        }.launchIn(viewModelScope)
    }

    private fun update(function: (SavedState) -> SavedState) = savedState.update(function)

    fun onEvent(event: SavedEvent) {
        when (event) {
            is SavedEvent.OnWatchLaterSelected -> {
                if (event.isAdded) {
                    addNewToWatchLaterUseCase.invoke(event.new.asDomain())
                } else {
                    deleteNewFromWatchLaterUseCase.invoke(event.new.asDomain())

                }
                loadAllWatchLater()
            }

            is SavedEvent.Refresh -> {
                loadAllWatchLater()
            }
        }
    }

    private fun loadAllWatchLater() {
        viewModelScope.launch {
            delay(1000)
            allWatchLaterUseCase.invoke(Unit).onEach { list ->
                update {
                    it.copy(watchLater = list.map { it.asUi() }
                        .onEach { it.apply { isWatchedLater.value = true } })
                }
            }.launchIn(viewModelScope)

        }
    }
}
