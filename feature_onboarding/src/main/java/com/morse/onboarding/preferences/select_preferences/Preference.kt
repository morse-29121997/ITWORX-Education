package com.morse.onboarding.preferences.select_preferences

import androidx.compose.runtime.mutableStateOf

data class Preference(
    val nameEn: String, // Country name in English
    val nameAr: String, // Country name in Arabic
    val key: String,     // Two-letter country code
    val image: String
) {
    val isSelected = mutableStateOf(false)

    companion object All {
        fun get() = listOf(
            Preference(
                nameEn = "Business",
                nameAr = "عمل",
                key = "business",
                image = "https://cdn-icons-png.flaticon.com/512/7521/7521450.png"
            ),
            Preference(
                nameEn = "Entertainment",
                nameAr = "ترفيه",
                key = "entertainment",
                image = "https://cdn.iconscout.com/icon/premium/png-256-thumb/entertainment-69-904401.png"
            ),
            Preference(
                nameEn = "General",
                nameAr = "عام",
                key = "general",
                image = "https://cdn-icons-png.flaticon.com/512/683/683546.png"
            ),
            Preference(
                nameEn = "Health",
                nameAr = "صحة",
                key = "health",

                image = "https://icons.veryicon.com/png/o/business/circular-multi-color-function-icon/health-health.png"
            ),
            Preference(
                nameEn = "Science",
                nameAr = "علوم",
                key = "science",
                image = "http://cdn-icons-png.flaticon.com/256/2022/2022299.png"
            ),
            Preference(
                nameEn = "Sports",
                nameAr = "الرياضة",
                key = "sports",
                image = "https://cdn-icons-png.flaticon.com/512/5351/5351478.png"
            ),
            Preference(
                nameEn = "Technology",
                nameAr = "تكنولوجيا",
                key = "technology",
                image = "https://cdn-icons-png.flaticon.com/512/2314/2314583.png"
            )
        )
    }
}