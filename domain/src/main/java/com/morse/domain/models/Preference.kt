package com.morse.domain.models

data class Preference(
    val nameEn: String, // Country name in English
    val nameAr: String, // Country name in Arabic
    val key: String,     // Two-letter country code
    val image: String
)