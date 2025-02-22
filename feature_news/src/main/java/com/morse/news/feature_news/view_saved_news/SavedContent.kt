package com.morse.news.feature_news.view_saved_news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.morse.core.theme.MyColor
import com.morse.core.theme.MyTypography
import com.morse.core.ui.Empty
import com.morse.core.ui.onStart
import com.morse.core.ui_models.New
import com.morse.news.R
import com.morse.news.feature_news.view_all_news.NewItem

@Composable
fun SavedContent(vm: SavedViewModel = hiltViewModel(), onPressed: (New) -> Unit) {
    val state = vm.savedState.collectAsState().value
    onStart {
        vm.onEvent(SavedEvent.Refresh)
    }
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

        if (state.watchLater.isEmpty()) {
            Empty(
                Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp)
            )
        } else {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp)
            ) {
                items(state.watchLater) { new ->
                    NewItem(new, onPressed) { _, _ ->
                        vm.onEvent(SavedEvent.OnWatchLaterSelected(new, false))
                    }
                }
            }
        }
    }
}