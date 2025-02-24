package com.morse.onboarding.splash

import androidx.lifecycle.ViewModel
import com.morse.domain.repositories.ISessionRepository
import com.morse.domain.usecases.onboarding.GetIsUserFirstTimeToAddPreferencesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val useCase: GetIsUserFirstTimeToAddPreferencesUseCase) : ViewModel() {
    fun isFirstTime() : Boolean = useCase(Unit)
}