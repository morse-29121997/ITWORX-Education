package com.morse.news.feature_news.view_all_news

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.morse.core.theme.MyColor
import com.morse.core.theme.MyTypography
import com.morse.core.ui_models.Preference
import com.morse.news.R

@Composable
fun HomeContent() {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HeadLineNewsSection()
        AllNewsSectionByCategorySection()
    }
}

@Composable
fun HeadLineNewsSection() {
    Text(
        text = stringResource(R.string.headlines),
        color = MyColor.color_9A9A9A,
        fontSize = 25.sp,
        fontWeight = FontWeight.ExtraBold,
        style = MyTypography.titleLarge,
        modifier = Modifier
            .padding(top = 5.dp, start = 10.dp, end = 10.dp)
    )

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        items(10) {
            HeadlineItem()
        }
    }
}

@Composable
fun AllNewsSectionByCategorySection() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 10.dp, end = 10.dp)
    ) {
        items(Preference.get()) {
            PreferenceChip(it) {
                it.isSelected.value = !it.isSelected.value
            }
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp)
    ) {
        items(30) {
            NewItem()
        }
    }
}

@Composable
fun NewItem() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 10.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.news_bg),
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp),
            contentScale = ContentScale.FillBounds,
            contentDescription = null
        )

        Row(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                "https://dims.apnews.com/dims4/default/7b855e3/2147483647/strip/true/crop/3431x1930+0+179/resize/1440x810!/quality/90/?url=https%3A%2F%2Fassets.apnews.com%2F64%2F31%2F7ac9a7c7d47c18a696606fb6cdcf%2F131c2627257c49a0a26d76433b3d4ddc",
                modifier = Modifier
                    .fillMaxWidth(0.45f)
                    .height(130.dp)
                    .clip(RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp))
                    .padding(1.dp),
                contentScale = ContentScale.FillBounds,
                contentDescription = null
            )

            Column(
                modifier = Modifier
                    .padding(vertical = 10.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "Part 2: 30 firms who donated Rs 335 cr to BJP were also stung by I-T, ED",
                    color = MyColor.color_FFFFFF,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    style = MyTypography.titleLarge,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )

                NewsTagItem(Modifier, "politics")
            }
        }

        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_add_to_saved),
            modifier = Modifier
                .align(
                    Alignment.BottomEnd
                ),
            contentDescription = null,
            contentScale = ContentScale.FillBounds

        )
    }
}

@Composable
fun HeadlineItem() {
    Box(
        modifier = Modifier
            .size(250.dp, 150.dp)
            .padding(horizontal = 10.dp)
    ) {
        AsyncImage(
            "https://dims.apnews.com/dims4/default/7b855e3/2147483647/strip/true/crop/3431x1930+0+179/resize/1440x810!/quality/90/?url=https%3A%2F%2Fassets.apnews.com%2F64%2F31%2F7ac9a7c7d47c18a696606fb6cdcf%2F131c2627257c49a0a26d76433b3d4ddc",
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(7)),
            contentScale = ContentScale.FillBounds,
            contentDescription = null
        )
        Image(
            painter = painterResource(R.drawable.place_headline_data_bg),
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .align(
                    Alignment.BottomCenter
                ),
            contentDescription = null,
            contentScale = ContentScale.FillBounds

        )

        HeadlineNewsContent(modifier = Modifier.align(Alignment.BottomStart))

        HeadlineTagItem(modifier = Modifier.align(Alignment.TopStart))

        Image(
            imageVector = ImageVector.vectorResource(R.drawable.ic_add_to_saved),
            modifier = Modifier
                .align(
                    Alignment.BottomEnd
                ),
            contentDescription = null,
            contentScale = ContentScale.FillBounds

        )
    }
}

@Composable
fun HeadlineTagItem(modifier: Modifier = Modifier, name: String = "Ground report") {
    Box(
        modifier = modifier
            .padding(start = 10.dp, top = 10.dp)
            .background(MyColor.color_ED1B23, CircleShape)
            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Text(
            text = name,
            color = MyColor.color_FFFFFF,
            fontSize = 12.sp,
            fontWeight = FontWeight.ExtraBold,
            style = MyTypography.titleLarge,
            modifier = modifier.align(alignment = Alignment.Center)
        )
    }
}

@Composable
fun NewsTagItem(modifier: Modifier = Modifier, name: String = "Ground report") {
    Box(
        modifier = modifier
            .padding(start = 10.dp, top = 10.dp)
            .background(MyColor.color_1877f2, CircleShape)
            .padding(horizontal = 1.dp, vertical = 1.dp)
            .background(MyColor.color_205192, CircleShape)
            .padding(horizontal = 20.dp, vertical = 5.dp)
    ) {
        Text(
            text = name,
            color = MyColor.color_FFFFFF,
            fontSize = 12.sp,
            fontWeight = FontWeight.ExtraBold,
            style = MyTypography.titleLarge,
            modifier = modifier.align(alignment = Alignment.Center)
        )
    }
}

@Composable
fun HeadlineNewsContent(modifier: Modifier = Modifier) {
    Column(modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
        Text(
            text = "March from Shambhu stalled, 1 from Punjab dead",
            color = MyColor.color_FFFFFF,
            fontSize = 12.sp,
            fontWeight = FontWeight.ExtraBold,
            style = MyTypography.titleLarge,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = "Jan 3,2024 by Basant Kumar",
            color = MyColor.color_A0A0A0,
            fontSize = 12.sp,
            fontWeight = FontWeight.ExtraBold,
            style = MyTypography.titleLarge,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )


    }
}

@Composable
fun PreferenceChip(preferences: Preference, onClicked: () -> Unit) {
    Column(
        modifier = Modifier.clickable { onClicked.invoke() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = preferences.nameEn,
            color = if (preferences.isSelected.value) MyColor.color_ED1B23 else MyColor.color_9A9A9A,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            style = MyTypography.titleLarge,
            modifier = Modifier
                .padding(top = 5.dp, start = 10.dp, end = 10.dp)
        )

        if (preferences.isSelected.value) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_under_line),
                contentDescription = null
            )
        }
    }
}