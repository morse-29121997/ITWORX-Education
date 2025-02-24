package com.morse.news.mapper

import com.morse.core.ui_models.Country as UICountry
import com.morse.domain.models.Country as DomainCountry
import com.morse.core.ui_models.Preference as UIPreference
import com.morse.domain.models.Preference as DomainPreference
import com.morse.domain.models.New as DomainNew
import com.morse.core.ui_models.New as UiNew

fun DomainNew.asUi() = UiNew(
    sourceName,
    author,
    title,
    url,
    urlToImage,
    publishedAt
)

fun UiNew.asDomain() = DomainNew(
    sourceName,
    author,
    title,
    url,
    urlToImage,
    publishedAt
)

fun DomainPreference.asUi() = UIPreference(
    nameEn, nameAr, key, image
).apply {
    isSelected.value = true
}


fun DomainCountry.asUi() = UICountry(
    nameEn, nameAr, key, flag
).apply {
    isSelected.value = true
}

