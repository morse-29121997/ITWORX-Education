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
import com.morse.core.ui_models.Country


@Composable
fun SelectCountry(
    countries: List<Country> = Country.get(),
    onCountrySelected: (Country) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp),
        contentPadding = PaddingValues(top = 10.dp, bottom = 40.dp)
    ) {
        items(countries.size) { index ->
            CountryItem(countries[index]) {
                countries.onEach { if (it.key != countries[index].key) it.isSelected.value = false }
                onCountrySelected.invoke(countries[index])
            }
        }

    }

}

@Composable
fun CountryItem(country: Country, onCountrySelected: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .size(100.dp)
            .clickable {
                onCountrySelected.invoke()
                country.isSelected.value = !country.isSelected.value
            }
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
            color = if (country.isSelected.value) MyColor.color_FFFFFF else MyColor.color_000000,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp)
        )
    }
}