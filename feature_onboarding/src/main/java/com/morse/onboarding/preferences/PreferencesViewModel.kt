package com.morse.onboarding.preferences

import androidx.lifecycle.ViewModel
import com.morse.core.ui_models.Country
import com.morse.core.ui_models.Preference
import com.morse.domain.repositories.ISessionRepository
import com.morse.domain.usecases.onboarding.AddIsUserFirstTimeToAddPreferencesUseCase
import com.morse.domain.usecases.onboarding.AddSelectedCountryUseCase
import com.morse.domain.usecases.onboarding.AddSelectedPreferencesUseCase
import com.morse.onboarding.mappers.asDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

sealed class PreferencesEvents {
    data class SelectCountry(val country: Country) : PreferencesEvents()
    data class SelectPreference(val preferences: Preference) : PreferencesEvents()
    data object Save : PreferencesEvents()
}

data class PreferencesState(
    val allCountries: List<Country>,
    val allPreferences: List<Preference>,
    val selectedCountry: Country? = null,
    val selectedPreferences: ArrayList<Preference> = arrayListOf()
)

@HiltViewModel
class PreferencesViewModel @Inject constructor(private val repo: ISessionRepository) : ViewModel() {
    private val addCountryUseCase by lazy { AddSelectedCountryUseCase(repo) }
    private val addPreferencesUseCase by lazy { AddSelectedPreferencesUseCase(repo) }
    private val addIsNotFirstTimeUseCase by lazy { AddIsUserFirstTimeToAddPreferencesUseCase(repo) }
    val preferencesState = MutableStateFlow(
        PreferencesState(
            allCountries = Country.get(),
            allPreferences = Preference.get(true),
            selectedPreferences = Preference.get(true),
        )
    )

    private fun update(function: (PreferencesState) -> PreferencesState) =
        preferencesState.update(function)

    fun onEvent(event: PreferencesEvents) {
        when (event) {
            is PreferencesEvents.SelectCountry -> update {
                it.copy(selectedCountry = event.country)
            }

            is PreferencesEvents.SelectPreference -> update {
                it.copy(selectedPreferences = it.selectedPreferences.apply {
                    if (contains(event.preferences)) {
                        remove(event.preferences)
                    } else {
                        add(event.preferences)
                    }
                })
            }

            is PreferencesEvents.Save -> {
                preferencesState.value.selectedCountry?.let {
                    addCountryUseCase(it.asDomain())

                }
                preferencesState.value.selectedPreferences.let {
                    addPreferencesUseCase(it.asDomain())
                }
                addIsNotFirstTimeUseCase(false)

            }
        }
    }

}