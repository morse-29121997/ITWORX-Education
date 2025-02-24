package com.morse.news.feature_news

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.morse.core.theme.MyColor
import com.morse.core.ui_models.New
import com.morse.news.R
import com.morse.news.coordinator.NewsDirections
import com.morse.news.feature_news.view_all_news.HomeContent
import com.morse.news.feature_news.view_saved_news.SavedContent


@Preview(showBackground = true)
@Composable
fun HomeScreen(onPressed: (New) -> Unit = {}, onNavigate: (NewsDirections) -> Unit = {}) {
    var currentScreen by remember {
        mutableStateOf<NewsDirections>(NewsDirections.Home.AllNews)
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.app_header_home_image),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 30.dp)
                .padding(horizontal = 10.dp)
                .size(173.dp, 30.dp)
        )

        Icon(
            Icons.Filled.Settings,
            contentDescription = "Search Icon",
            tint = MyColor.color_FFFFFF,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 30.dp, end = 10.dp)
                .clickable {
                    onNavigate.invoke(NewsDirections.Preferences)
                }
        )

        Icon(
            imageVector = ImageVector.vectorResource(if (Locale.current.language == "ar") R.drawable.en_language_icon else R.drawable.ar_language_icon),
            contentDescription = "Search Icon",
            tint = MyColor.color_FFFFFF,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 30.dp, end = 50.dp)

                .size(30.dp)
                .clickable {
                    onNavigate.invoke(NewsDirections.Preferences)
                }
        )


        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
                .fillMaxHeight(0.8F)
        ) {

            when (currentScreen) {
                NewsDirections.Home.AllNews -> HomeContent(onPressed = onPressed)
                else -> SavedContent(onPressed = onPressed)
            }

        }



        HomeBottomNavigation(
            modifier = Modifier.align(alignment = Alignment.BottomCenter),
            currentScreen
        ) {
            currentScreen =
                if (it == NewsDirections.Home.SavedNews) NewsDirections.Home.SavedNews else NewsDirections.Home.AllNews

        }

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 60.dp)
                .size(80.dp)
                .align(Alignment.BottomCenter)
                .clickable { onNavigate.invoke(NewsDirections.Search) },
            contentScale = ContentScale.FillBounds
        )

        Image(
            painter = painterResource(id = R.drawable.ic_half_circule),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp, 20.dp)
                .align(Alignment.BottomCenter),
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun HomeBottomNavigation(
    modifier: Modifier = Modifier,
    currentScreen: NewsDirections = NewsDirections.Home.AllNews,
    onNavigate: (NewsDirections) -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(bottom = 30.dp)
            .height(63.dp)
            .background(MyColor.color_262626, CircleShape)
            .then(modifier),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavigationItem(
            modifier = Modifier.weight(1f),
            currentScreen == NewsDirections.Home.AllNews,
            stringResource(R.string.home),
            R.drawable.ic_home
        ) {
            onNavigate.invoke(NewsDirections.Home.AllNews)
        }

        NavigationItem(
            modifier = Modifier.weight(1f),
            currentScreen == NewsDirections.Home.SavedNews,
            stringResource(R.string.saved),
            R.drawable.ic_saved
        ) {
            onNavigate.invoke(NewsDirections.Home.SavedNews)
        }
    }
}

@Composable
fun NavigationItem(
    modifier: Modifier,
    isSelected: Boolean,
    name: String,
    icon: Int,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = null,
            modifier = Modifier
                .size(if (isSelected) 25.dp else 20.dp)
                .clickable { onClick.invoke() },
            tint = if (isSelected) MyColor.color_EA4335 else MyColor.color_C6C6C6
        )
        Text(
            text = name,
            color = if (isSelected) MyColor.color_EA4335 else MyColor.color_C6C6C6,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .padding(top = 5.dp)
                .clickable { onClick.invoke() }
        )
    }
}