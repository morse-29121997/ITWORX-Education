package com.morse.onboarding.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.morse.core.theme.MyColor
import com.morse.core.theme.MyTypography
import com.morse.onboarding.R
import kotlinx.coroutines.delay


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreen(
    vm: SplashViewModel = hiltViewModel(),
    onNavigate: (Boolean) -> Unit = {}
) {
    LaunchedEffect(Unit) {
        delay(3000)
        onNavigate(vm.isFirstTime())
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.on_boarding_bg),
            contentDescription = null,
            modifier = Modifier.size(2000.dp, 2000.dp),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Text(
                text = stringResource(R.string.newsy),
                style = MyTypography.titleLarge,
                color = MyColor.color_FFFFFF,
                modifier = Modifier.padding(top = 20.dp),
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp
            )

            Text(
                text = stringResource(R.string.news_you_can_trust),
                style = MyTypography.titleLarge,
                color = MyColor.color_FFFFFF,
                modifier = Modifier.padding(top = 60.dp),
                fontWeight = FontWeight.SemiBold,
                lineHeight = 65.sp,
                fontSize = 60.sp
            )

            Image(
                painter = painterResource(id = R.drawable.ic_news),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(290.dp)
                    .padding(top = 50.dp)
                    .rotate(-25f)
            )

        }

        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp),
            color = MyColor.color_000000,
            trackColor = MyColor.color_FFFFFF
        )
    }
}
