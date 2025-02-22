package com.morse.domain.usecases.onboarding

import com.morse.domain.base.UseCase
import com.morse.domain.models.Country
import com.morse.domain.models.Preference
import com.morse.domain.repositories.ISessionRepository

class AddSelectedPreferencesUseCase (private val repo: ISessionRepository) : UseCase<List<Preference>, Unit>() {
    override fun execute(input: List<Preference>) {
        return repo.addPreferredPreference(input)
    }
}