package com.morse.news.feature_search

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.morse.core.theme.MyColor
import com.morse.core.theme.MyTypography
import com.morse.core.ui.items
import com.morse.core.ui_models.New
import com.morse.news.R
import com.morse.news.feature_news.view_all_news.NewItem


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SearchScreen(
    vm: SearchViewModel = hiltViewModel(),
    onPressed: (New) -> Unit = {},
    onClose: () -> Unit = {}
) {
    val headlines = vm.searchState.collectAsState().value.headlineNews.collectAsLazyPagingItems()
    var search by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.padding(top = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_back),
                    contentDescription = null,
                    tint = MyColor.color_FFFFFF,
                    modifier = Modifier
                        .clickable {
                            onClose.invoke()
                        },
                )

                Text(
                    text = stringResource(R.string.search_on_news),
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    style = MyTypography.bodyMedium,
                    color = MyColor.color_FFFFFF,
                    modifier = Modifier.padding(start = 20.dp)
                )
            }


            TextField(
                value = search,
                onValueChange = { search = it },
                label = {
                    Text(
                        stringResource(R.string.search),
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        style = MyTypography.bodyMedium
                    )
                },
                placeholder = {
                    Text(
                        stringResource(R.string.write_here),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 13.sp,
                        style = MyTypography.bodyMedium,
                    )
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(
                    onSearch = { vm.onEvent(SearchEvent.Search(search)) }
                ),
                singleLine = true,
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search Icon") },
                trailingIcon = {
                    if (search.isNotEmpty()) {
                        IconButton(onClick = {
                            search = ""
                            vm.onEvent(SearchEvent.Search(search))
                        }) {
                            Icon(Icons.Filled.Clear, contentDescription = "Clear Text")
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 10.dp),
                shape = RoundedCornerShape(50),
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = MyColor.color_000000,
                    focusedContainerColor = MyColor.color_000000,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = MyColor.color_FFFFFF,
                    unfocusedTextColor = MyColor.color_af0909,
                    focusedLabelColor = MyColor.color_af0909,
                    cursorColor = MyColor.color_af0909,

                    ),
            )

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 10.dp)
            ) {
                items(headlines) { headline ->
                    NewItem(headline, onPressed) { new, isSaved ->
                        vm.onEvent(SearchEvent.OnWatchLaterSelected(new, isSaved))
                    }
                }
            }
        }

    }
}