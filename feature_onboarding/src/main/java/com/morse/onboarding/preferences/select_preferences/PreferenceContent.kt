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
import androidx.compose.runtime.collectAsState
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
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.morse.core.theme.MyColor
import com.morse.core.theme.MyTypography
import com.morse.core.ui_models.Preference
import com.morse.onboarding.preferences.PreferencesEvents
import com.morse.onboarding.preferences.PreferencesViewModel


@Composable
fun SelectPreferences(
    vm : PreferencesViewModel = hiltViewModel()
) {
    val preferences = vm.preferencesState.collectAsState().value.allPreferences
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp),
        contentPadding = PaddingValues(top = 10.dp, bottom = 40.dp)
    ) {
        items(preferences.size) { index ->
            PreferenceItem(preferences[index]){
                vm.onEvent(PreferencesEvents.SelectPreference(preferences[index]))
            }
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
