package com.morse.domain.usecases.onboarding

import com.morse.domain.base.UseCase
import com.morse.domain.repositories.ISessionRepository

class GetIsUserFirstTimeToAddPreferencesUseCase (private val repo: ISessionRepository) : UseCase<Unit, Boolean>() {
    override fun execute(input: Unit): Boolean {
        return repo.isFirstTime()
    }
}