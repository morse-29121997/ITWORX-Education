package com.morse.datasource.local.preference

import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import com.morse.domain.models.Country
import com.morse.domain.models.Preference
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsPreferenceManager @Inject constructor(private val sharedPrefsInstance: SharedPreferences) {

    private val isFirstTimeKey = "isFirstTime"
    private val preferredCountryKey = "preferredCountry"
    private val preferredPreferencesKey = "preferredPreferences"

    fun isFirstTime(): Boolean {
        return sharedPrefsInstance.getBoolean(isFirstTimeKey, true)
    }
    fun addFirstTime(value : Boolean) {
        sharedPrefsInstance.edit{
            putBoolean(isFirstTimeKey, value)
            apply()
        }
    }
    fun savePreferredCountry(country: Country) {
        val con = Gson().toJson(country)
        sharedPrefsInstance.edit {
            putString(preferredCountryKey , con)
            apply()
        }
    }
    fun getPreferredCountry() : Country? {
        return Gson().fromJson(sharedPrefsInstance.getString(preferredCountryKey, null), Country::class.java)
    }

    fun savePreferredPreferences(preferences: List<Preference>) {
        val pref = preferences.map { Gson().toJson(it) }
        sharedPrefsInstance.edit {
            putStringSet(preferredPreferencesKey, pref.toSet())
            apply()
        }
    }

    fun getPreferredPreferences(): List<Preference> {
        return sharedPrefsInstance.getStringSet(preferredPreferencesKey, emptySet())?.map { Gson().fromJson(it, Preference::class.java) } ?: emptyList()
    }


}