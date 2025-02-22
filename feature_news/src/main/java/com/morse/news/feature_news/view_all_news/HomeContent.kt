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
import androidx.compose.runtime.collectAsState
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import com.morse.core.extensions.convertDateWithTime
import com.morse.core.theme.MyColor
import com.morse.core.theme.MyTypography
import com.morse.core.ui.items
import com.morse.core.ui_models.Country
import com.morse.core.ui_models.New
import com.morse.core.ui_models.Preference
import com.morse.core.ui_models.Source
import com.morse.news.R
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun HomeContent(vm: NewsViewModel = hiltViewModel(), onPressed: (New) -> Unit) {
    val state = vm.newsState.collectAsState().value
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HeadLineNewsSection(state.headlineNews.collectAsLazyPagingItems(), { new, isSaved ->
            vm.onEvent(NewsEvent.OnWatchLaterSelected(new, isSaved))
        }, onPressed)
        AllNewsSectionByCategorySection(
            state.allSources,
            state.allNews.collectAsLazyPagingItems(),
            { vm.onEvent(NewsEvent.OnSourceSelected(it)) }, { new, isSaved ->
                vm.onEvent(NewsEvent.OnWatchLaterSelected(new, isSaved))
            },
            onPressed
        )
    }
}

@Composable
fun HeadLineNewsSection(
    news: LazyPagingItems<New>,
    onSavedClicked: (New, Boolean) -> Unit,
    onPressed: (New) -> Unit
) {
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
        items(news) { new ->
            HeadlineItem(new, onSavedClicked, onPressed)
        }
    }
}

@Composable
fun AllNewsSectionByCategorySection(
    sources: List<Source>,
    news: LazyPagingItems<New>,
    onPreferenceSelected: (Source) -> Unit,
    onSavedClicked: (New, Boolean) -> Unit,
    onNewPressed: (New) -> Unit,
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 10.dp, end = 10.dp)
    ) {
        items(sources) { source ->
            PreferenceChip(source) {
                source.isSelected.value = !source.isSelected.value
                sources.onEach {
                    if (it.key != source.key) {
                        it.isSelected.value = false
                    }
                }
                onPreferenceSelected.invoke(source)
            }
        }
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp)
    ) {
        items(news) { new ->
            NewItem(new, onNewPressed, onSavedClicked)
        }
    }
}

@Composable
fun NewItem(new: New, onPressed: (New) -> Unit, onSavedClicked: (New, Boolean) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 10.dp)
            .clickable { onPressed.invoke(new) }
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
                new.urlToImage,
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
                    text = new.title,
                    color = MyColor.color_FFFFFF,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    style = MyTypography.titleLarge,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )

                NewsTagItem(Modifier, new.sourceName)
            }
        }

        Image(
            imageVector = ImageVector.vectorResource(if (new.isWatchedLater.value) R.drawable.ic_added_to_saved else R.drawable.ic_add_to_saved),
            modifier = Modifier
                .align(
                    Alignment.BottomEnd
                )
                .clickable {
                    when (new.isWatchedLater.value) {
                        true -> onSavedClicked.invoke(new, false)
                        false -> onSavedClicked.invoke(new, true)
                    }
                    new.isWatchedLater.value = !new.isWatchedLater.value
                },
            contentDescription = null,
            contentScale = ContentScale.FillBounds

        )
    }
}

@Composable
fun HeadlineItem(new: New, onSavedClicked: (New, Boolean) -> Unit, onPressed: (New) -> Unit) {
    Box(
        modifier = Modifier
            .size(250.dp, 150.dp)
            .padding(horizontal = 10.dp)
            .clickable {
                onPressed.invoke(new)
            }
    ) {
        AsyncImage(
            new.urlToImage,
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

        HeadlineNewsContent(modifier = Modifier.align(Alignment.BottomStart), new)

        HeadlineTagItem(modifier = Modifier.align(Alignment.TopStart))

        Image(
            imageVector = ImageVector.vectorResource(if (new.isWatchedLater.value) R.drawable.ic_added_to_saved else R.drawable.ic_add_to_saved),
            modifier = Modifier
                .align(
                    Alignment.BottomEnd
                )
                .clickable {
                    when (new.isWatchedLater.value) {
                        true -> onSavedClicked.invoke(new, false)
                        false -> onSavedClicked.invoke(new, true)
                    }
                    new.isWatchedLater.value = !new.isWatchedLater.value
                },
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
fun HeadlineNewsContent(modifier: Modifier = Modifier, new: New) {
    Column(modifier.padding(horizontal = 10.dp, vertical = 10.dp)) {
        Text(
            text = new.title,
            color = MyColor.color_FFFFFF,
            fontSize = 12.sp,
            fontWeight = FontWeight.ExtraBold,
            style = MyTypography.titleLarge,
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = stringResource(R.string.by, new.publishedAt.convertDateWithTime(), new.author ?: "-"),
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
fun PreferenceChip(source: Source, onClicked: () -> Unit) {
    Column(
        modifier = Modifier.clickable { onClicked.invoke() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = source.name,
            color = if (source.isSelected.value) MyColor.color_ED1B23 else MyColor.color_9A9A9A,
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            style = MyTypography.titleLarge,
            modifier = Modifier
                .padding(top = 5.dp, start = 10.dp, end = 10.dp)
        )

        if (source.isSelected.value) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_under_line),
                contentDescription = null
            )
        }
    }
}