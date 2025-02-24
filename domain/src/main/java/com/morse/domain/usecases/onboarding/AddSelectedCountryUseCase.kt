package com.morse.domain.usecases.onboarding

import com.morse.domain.base.UseCase
import com.morse.domain.models.Country
import com.morse.domain.repositories.ISessionRepository
import javax.inject.Inject

class AddSelectedCountryUseCase @Inject constructor(private val repo: ISessionRepository) : UseCase<Country, Unit>() {
    override fun execute(input: Country): Unit {
        return repo.addPreferredCountry(input)
    }
}