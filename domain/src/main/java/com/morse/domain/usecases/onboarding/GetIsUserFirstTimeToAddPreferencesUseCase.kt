package com.morse.domain.usecases.onboarding

import com.morse.domain.base.UseCase
import com.morse.domain.repositories.ISessionRepository
import javax.inject.Inject

class GetIsUserFirstTimeToAddPreferencesUseCase @Inject constructor(private val repo: ISessionRepository) :
    UseCase<Unit, Boolean>() {
    override fun execute(input: Unit): Boolean {
        return repo.isFirstTime()
    }
}