package com.morse.domain.usecases.onboarding

import com.morse.domain.base.UseCase
import com.morse.domain.repositories.ISessionRepository
import javax.inject.Inject

class AddIsUserFirstTimeToAddPreferencesUseCase @Inject constructor(private val repo: ISessionRepository) :
    UseCase<Boolean, Unit>() {
    override fun execute(input: Boolean): Unit {
        return repo.addIsFirstTime(input)
    }
}