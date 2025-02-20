package com.morse.onboarding.preferences.select_country

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.morse.core.theme.MyColor
import com.morse.core.theme.MyTypography
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
            ).apply {
                isSelected.value  = true
            },
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

@Composable
fun SelectCountry(countries: List<Country> = Country.get(), onCountrySelected: () -> Unit = {}) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize().padding(vertical = 10.dp),
        contentPadding = PaddingValues(top = 10.dp , bottom = 40 .dp)
    ) {
        items(countries.size) { index ->
            CountryItem(countries[index], onCountrySelected)
        }
    }

}

@Composable
fun CountryItem(country: Country, onCountrySelected: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally ,
        modifier = Modifier
            .size(100.dp)
            .clickable { onCountrySelected.invoke()
                country.isSelected.value = !country.isSelected.value}
            .padding(20.dp)
            .background(
                if (country.isSelected.value) MyColor.color_af0909 else MyColor.color_FFFFFF,
                RoundedCornerShape(5.dp)
            )
            .padding(horizontal = 5.dp)
            .padding(vertical = 5.dp)
    ) {
        Text(
            text = country.flag ?: "",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            style = MyTypography.bodyMedium,
            color = MyColor.color_FFFFFF
        )

        Text(
            text = country.nameEn,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            textAlign = TextAlign.Center,
            style = MyTypography.bodyMedium,
            color =  if (country.isSelected.value) MyColor.color_FFFFFF else MyColor.color_000000,
            modifier = Modifier.fillMaxWidth().padding(top = 2.dp)
        )
    }
}