package com.morse.domain.models

data class Country(
    val nameEn: String, // Country name in English
    val nameAr: String, // Country name in Arabic
    var key: String,     // Two-letter country code
    var flag : String ?=null
)