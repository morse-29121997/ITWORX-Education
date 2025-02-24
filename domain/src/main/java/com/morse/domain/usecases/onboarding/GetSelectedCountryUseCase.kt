package com.morse.domain.usecases.onboarding

import com.morse.domain.base.UseCase
import com.morse.domain.models.Country
import com.morse.domain.models.Preference
import com.morse.domain.repositories.ISessionRepository
import javax.inject.Inject

class GetSelectedCountryUseCase  @Inject constructor(private val repo: ISessionRepository) : UseCase<Unit, Country?>() {
    override fun execute(input: Unit) : Country? {
        return repo.getPreferredCountry()
    }
}