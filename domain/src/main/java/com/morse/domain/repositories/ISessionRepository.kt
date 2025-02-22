package com.morse.domain.repositories

import com.morse.domain.models.Country
import com.morse.domain.models.Preference

interface ISessionRepository {
    fun isFirstTime() : Boolean
    fun addIsFirstTime(boolean: Boolean)
    fun addPreferredCountry(country : Country)
    fun getPreferredCountry() : Country?
    fun getPreferredPreferences() : List<Preference>
    fun addPreferredPreference(preferences : List<Preference>)
}