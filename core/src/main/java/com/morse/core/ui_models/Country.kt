package com.morse.core.ui_models

import androidx.compose.runtime.mutableStateOf
import java.util.Locale

data class Country(
    val nameEn: String, // Country name in English
    val nameAr: String, // Country name in Arabic
    var key: String,     // Two-letter country code
    var flag : String ?=null
) {
    val isSelected = mutableStateOf(false)
    fun updateFlag(): Country {
        flag = key
            .uppercase(Locale.US)
            .map { char ->
                Character.codePointAt("$char", 0) - 0x41 + 0x1F1E6
            }
            .map { codePoint ->
                Character.toChars(codePoint)
            }
            .joinToString(separator = "") { charArray ->
                String(charArray)
            }
        return this
    }


    companion object All {
        fun get() = listOf(
            Country(
                nameEn = "United Arab Emirates",
                nameAr = "الإمارات العربية المتحدة",
                key = "ae",
            ),
            Country(
                nameEn = "Argentina",
                nameAr = "الأرجنتين",
                key = "ar",
            ),
            Country(
                nameEn = "Austria",
                nameAr = "النمسا",
                key = "at",
            ),
            Country(
                nameEn = "Australia",
                nameAr = "أستراليا",
                key = "au",
            ),
            Country(
                nameEn = "Belgium",
                nameAr = "بلجيكا",
                key = "be",
            ),
            Country(
                nameEn = "Bulgaria",
                nameAr = "بلغاريا",
                key = "bg",
            ),
            Country(
                nameEn = "Brazil",
                nameAr = "البرازيل",
                key = "br",
            ),
            Country(
                nameEn = "Canada",
                nameAr = "كندا",
                key = "ca",
            ),
            Country(
                nameEn = "Switzerland",
                nameAr = "سويسرا",
                key = "ch",
            ),
            Country(
                nameEn = "China",
                nameAr = "الصين",
                key = "cn",
            ),
            Country(
                nameEn = "Colombia",
                nameAr = "كولومبيا",
                key = "co",
            ),
            Country(
                nameEn = "Cuba",
                nameAr = "كوبا",
                key = "cu",
            ),
            Country(
                nameEn = "Czech Republic",
                nameAr = "جمهورية التشيك",
                key = "cz",
            ),
            Country(
                nameEn = "Germany",
                nameAr = "ألمانيا",
                key = "de",
            ),
            Country(
                nameEn = "Egypt",
                nameAr = "مصر",
                key = "eg",
            ),
            Country(
                nameEn = "France",
                nameAr = "فرنسا",
                key = "fr",
            ),
            Country(
                nameEn = "United Kingdom",
                nameAr = "المملكة المتحدة",
                key = "gb",
            ),
            Country(
                nameEn = "Greece",
                nameAr = "اليونان",
                key = "gr",
            ),
            Country(
                nameEn = "Hong Kong",
                nameAr = "هونغ كونغ",
                key = "hk",
            ),
            Country(
                nameEn = "Hungary",
                nameAr = "المجر",
                key = "hu",
            ),
            Country(
                nameEn = "Indonesia",
                nameAr = "إندونيسيا",
                key = "id",
            ),
            Country(
                nameEn = "Ireland",
                nameAr = "أيرلندا",
                key = "ie",
            ),
            Country(
                nameEn = "Israel",
                nameAr = "إسرائيل",
                key = "il",
            ),
            Country(
                nameEn = "India",
                nameAr = "الهند",
                key = "in",
            ),
            Country(
                nameEn = "Italy",
                nameAr = "إيطاليا",
                key = "it",
            ),
            Country(
                nameEn = "Japan",
                nameAr = "اليابان",
                key = "jp",
            ),
            Country(
                nameEn = "South Korea",
                nameAr = "كوريا الجنوبية",
                key = "kr",
            ),
            Country(
                nameEn = "Lithuania",
                nameAr = "ليتوانيا",
                key = "lt",
            ),
            Country(
                nameEn = "Latvia",
                nameAr = "لاتفيا",
                key = "lv",
            ),
            Country(
                nameEn = "Morocco",
                nameAr = "المغرب",
                key = "ma",
            ),
            Country(
                nameEn = "Mexico",
                nameAr = "المكسيك",
                key = "mx",
            ),
            Country(
                nameEn = "Malaysia",
                nameAr = "ماليزيا",
                key = "my",
            ),
            Country(
                nameEn = "Nigeria",
                nameAr = "نيجيريا",
                key = "ng",
            ),
            Country(
                nameEn = "Netherlands",
                nameAr = "هولندا",
                key = "nl",
            ),
            Country(
                nameEn = "Norway",
                nameAr = "النرويج",
                key = "no",
            ),
            Country(
                nameEn = "New Zealand",
                nameAr = "نيوزيلندا",
                key = "nz",
            ),
            Country(
                nameEn = "Philippines",
                nameAr = "الفلبين",
                key = "ph",
            ),
            Country(
                nameEn = "Poland",
                nameAr = "بولندا",
                key = "pl",
            ),
            Country(
                nameEn = "Portugal",
                nameAr = "البرتغال",
                key = "pt",
            ),
            Country(
                nameEn = "Romania",
                nameAr = "رومانيا",
                key = "ro",
            ),
            Country(
                nameEn = "Serbia",
                nameAr = "صربيا",
                key = "rs",
            ),
            Country(
                nameEn = "Russia",
                nameAr = "روسيا",
                key = "ru",
            ),
            Country(
                nameEn = "Saudi Arabia",
                nameAr = "المملكة العربية السعودية",
                key = "sa",
            ),
            Country(
                nameEn = "Sweden",
                nameAr = "السويد",
                key = "se",
            ),
            Country(
                nameEn = "Singapore",
                nameAr = "سنغافورة",
                key = "sg",
            ),
            Country(
                nameEn = "Slovenia",
                nameAr = "سلوفينيا",
                key = "si",
            ),
            Country(
                nameEn = "Slovakia",
                nameAr = "سلوفاكيا",
                key = "sk",
            ),
            Country(
                nameEn = "Thailand",
                nameAr = "تايلاند",
                key = "th",
            ),
            Country(
                nameEn = "Turkey",
                nameAr = "تركيا",
                key = "tr",
            ),
            Country(
                nameEn = "Taiwan",
                nameAr = "تايوان",
                key = "tw",
            ),
            Country(
                nameEn = "Ukraine",
                nameAr = "أوكرانيا",
                key = "ua",
            ),
            Country(
                nameEn = "United States",
                nameAr = "الولايات المتحدة",
                key = "us",
            ),
            Country(
                nameEn = "Venezuela",
                nameAr = "فنزويلا",
                key = "ve",
            ),
            Country(
                nameEn = "South Africa",
                nameAr = "جنوب أفريقيا",
                key = "za",
            ),
        ).map { it.updateFlag() }
    }
}