package com.morse.datasource.repositories

import com.morse.datasource.local.preference.NewsPreferenceManager
import com.morse.domain.models.Country
import com.morse.domain.models.Preference
import com.morse.domain.repositories.ISessionRepository
import javax.inject.Inject


class SessionRepository @Inject constructor (private val preference : NewsPreferenceManager) : ISessionRepository {

    override fun isFirstTime(): Boolean {
        return preference.isFirstTime()
    }

    override fun addIsFirstTime(boolean: Boolean) {
        preference.addFirstTime(boolean)
    }

    override fun addPreferredCountry(country: Country) {
        return preference.savePreferredCountry(country)
    }

    override fun getPreferredCountry(): Country? {
        return preference.getPreferredCountry()
    }

    override fun getPreferredPreferences(): List<Preference> {
       return preference.getPreferredPreferences()
    }

    override fun addPreferredPreference(preferences: List<Preference>) {
        return preference.savePreferredPreferences(preferences)
    }

}