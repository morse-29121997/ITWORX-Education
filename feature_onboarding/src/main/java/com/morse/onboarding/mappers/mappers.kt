package com.morse.onboarding.mappers

import com.morse.core.ui_models.Country
import com.morse.domain.models.Country as DomainCountry
import com.morse.core.ui_models.Preference
import okhttp3.internal.immutableListOf
import com.morse.domain.models.Preference as DomainPreference

fun Country.asDomain(): DomainCountry = DomainCountry(
    nameEn, nameAr, key, flag
)

fun List<Preference>.asDomain(): List<DomainPreference> = map {
    DomainPreference(
        it.nameEn, it.nameAr, it.key, it.image
    )
}

fun DomainCountry.asUI(): Country = Country(
    nameEn, nameAr, key, flag
)

fun List<DomainPreference>.asUI(): List<Preference> = map {
    Preference(
        it.nameEn, it.nameAr, it.key, it.image
    )
}