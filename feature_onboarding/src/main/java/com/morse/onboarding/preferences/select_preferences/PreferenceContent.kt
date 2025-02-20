package com.morse.onboarding.preferences.select_preferences

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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.compose.SubcomposeAsyncImage
import coil3.compose.SubcomposeAsyncImageContent
import coil3.imageLoader
import com.morse.core.theme.MyColor
import com.morse.core.theme.MyTypography
import com.morse.onboarding.R
import com.morse.onboarding.preferences.select_country.Country
import com.morse.onboarding.preferences.select_country.CountryItem
import java.util.Locale

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


@Composable
fun SelectPreferences(
    preferences: List<Preference> = Preference.get(),
    onPreferenceSelected: () -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp),
        contentPadding = PaddingValues(top = 10.dp, bottom = 40.dp)
    ) {
        items(preferences.size) { index ->
            PreferenceItem(preferences[index], onPreferenceSelected)
        }
    }

}

@Composable
fun PreferenceItem(preference: Preference, onCountrySelected: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .size(100.dp)
            .clickable {
                onCountrySelected.invoke()
                preference.isSelected.value = !preference.isSelected.value
            }
            .padding(20.dp)
            .background(
                if (preference.isSelected.value) MyColor.color_af0909 else MyColor.color_FFFFFF,
                RoundedCornerShape(5.dp)
            )
            .padding(horizontal = 5.dp)
            .padding(vertical = 5.dp)
    ) {

        AsyncImage(
            model =  preference.image,
            contentDescription = null,
            modifier = Modifier.size(30.dp)
        )

        Text(
            text = preference.nameEn,
            fontWeight = FontWeight.Bold,
            fontSize = 13.sp,
            textAlign = TextAlign.Center,
            style = MyTypography.bodyMedium,
            color = if (preference.isSelected.value) MyColor.color_FFFFFF else MyColor.color_000000,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp)
        )
    }
}
