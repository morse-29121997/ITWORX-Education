package com.morse.news.feature_news.view_saved_news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.morse.core.theme.MyColor
import com.morse.core.theme.MyTypography
import com.morse.news.R
import com.morse.news.feature_news.view_all_news.NewItem

@Composable
fun SavedContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = stringResource(R.string.saved_news),
            color = MyColor.color_9A9A9A,
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold,
            style = MyTypography.titleLarge,
            modifier = Modifier
                .padding(top = 5.dp, start = 10.dp, end = 10.dp)
        )

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
}