package com.morse.core.ui

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.morse.core.R
import com.morse.core.theme.MyColor


@Composable
fun MyButtonMain(
    stringResourceId: Int,
    modifier: Modifier = Modifier,
    isValid: Boolean = true,
    onValidClick: () -> Unit,
) {
    TextButton(
        shape = RoundedCornerShape(5.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = if (isValid) 1.dp else 0.dp),
        contentPadding = PaddingValues(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isValid) MyColor.color_EA5B59 else MyColor.color_EA5B59.copy(alpha = 0.5f),
            contentColor = if (isValid) MyColor.color_EA5B59 else MyColor.color_EA5B59.copy(alpha = 0.5f),
        ),

        modifier = Modifier
            .height(54.dp)
            .wrapContentHeight()
            .then(modifier),
        onClick = {
            if (isValid) {
                onValidClick()
            }
        }
    ) {
        Text(
            stringResource(
                stringResourceId
            ),
            color = MyColor.color_FFFFFF,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Composable
fun MyButtonGrey(
    stringResourceId: Int,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    color: Color = MyColor.color_D7DADF,
    onClick: () -> Unit,
) {
    TextButton(
        enabled = enabled,
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp),
        contentPadding = PaddingValues(10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            disabledContainerColor = color.copy(alpha = 0.4f),
        ),

        modifier = Modifier
            .height(54.dp)
            .wrapContentHeight()
            .then(modifier),
        onClick = onClick,
        shape = RoundedCornerShape(5.dp)
    ) {

        Text(
            text = stringResource(stringResourceId),
            color = MyColor.color_000000,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Composable
fun Indicators(
    modifier: Modifier = Modifier.fillMaxWidth(),
    size: Int,
    index: Int,
    isFirstPage: Boolean = false,
    fromHome: Boolean = false,
    onClick: () -> Unit = {}
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        repeat(size) {
            Indicator(isSelected = it == index, isFirstPage, fromHome = fromHome, onClick = onClick)
        }
    }
}


@Composable
fun Indicator(
    isSelected: Boolean,
    isFirstPage: Boolean = false,
    fromHome: Boolean = false,
    onClick: () -> Unit = {}
) {

    val size by animateDpAsState(
        targetValue = if (isSelected) 6.dp else 6.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessHigh
        ), label = ""
    )


    if (isSelected) {
        Box(
            modifier = Modifier
                .padding(3.dp)
                .background(MyColor.color_FFFFFF, CircleShape)
                .padding(1.dp)
                .background(
                    if (isFirstPage) MyColor.color_000000
                    else MyColor.color_af0909, CircleShape
                )
                .padding(2.dp)
                .size(size)
                // .padding1()
                .background(MyColor.color_af0909, CircleShape)


        )
    } else {
        Box(
            modifier = Modifier
                .padding(all = 6.dp)
                .size(size)
                .clip(CircleShape)
                .background(
                    MyColor.color_FFFFFF
                )
                .clickable {
                    if (fromHome) {
                        onClick.invoke()
                    }
                }
        )
    }
}


@Composable
fun Loading(modifier: Modifier) {
    Box(modifier = modifier) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.loading))
        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.Center)
        )
    }
}

@Composable
fun Error(modifier: Modifier, message: String) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.fail))

        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier.size(200.dp)
        )

        Text(
            text = message,
            color = MyColor.color_FFFFFF,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
        )

    }
}


@Composable
fun Empty(modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.empty))

        LottieAnimation(
            composition = composition,
            iterations = LottieConstants.IterateForever,
            modifier = Modifier.size(200.dp)
        )

        Text(
            text = stringResource(R.string.no_news_found),
            color = MyColor.color_FFFFFF,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
        )

    }
}


@Composable
fun <T : Any> LazyPagingItems<T>.ComposeDefault(
    modifier: Modifier = Modifier
        .fillMaxSize()
        .padding(bottom = 0.dp),
    viewError: Boolean = true,
    viewLoading: Boolean = true,
    viewEmpty: Boolean = true,
    loadingSize: Dp = 250.dp,
    Error: @Composable (String, onRetry: (() -> Unit)) -> Unit = { msg, onRetry ->
        if (viewError) Error(Modifier.fillMaxSize(), message = msg)
    },
    Loading: (@Composable () -> Unit)? = {
        if (viewLoading) Loading(
            Modifier.size(loadingSize)
        )
    },
    Empty: (@Composable () -> Unit)? = {
        if (viewEmpty) Empty(
            Modifier.fillMaxSize()
        )
    },
    emptyCondition: () -> Boolean = {
        (loadState.refresh is LoadState
        .NotLoading).and(itemCount == 0)
    },

    ) {


    Box(Modifier.fillMaxSize()) {

        when {
            loadState.source.refresh is LoadState.Loading -> Loading?.invoke()
            loadState.refresh is LoadState.Loading -> Loading?.invoke()
            loadState.refresh is LoadState.Error -> Error.invoke(getError(), ::refresh)
            emptyCondition.invoke() -> {
                Empty?.invoke()
            }
        }
    }

}

fun LazyPagingItems<*>.isSuccess() = (loadState.refresh is LoadState.NotLoading).and(itemCount > 0)
fun LazyPagingItems<*>.isLoading() = loadState.refresh == LoadState.Loading
fun LazyPagingItems<*>.isAppendLoading() = loadState.append == LoadState.Loading
fun LazyPagingItems<*>.isError() = loadState.refresh is LoadState.Error
fun LazyPagingItems<*>.isNotSuccess2() = isError() or isLoading() or isEmpty()
fun LazyPagingItems<*>.isEmpty() = itemCount == 0
fun <T : Any> LazyPagingItems<T>.getError() =
    (this.loadState.refresh as? LoadState.Error)?.error?.message ?: "Error"

fun <T : Any> LazyListScope.items(
    items: LazyPagingItems<T>,
    key: ((item: @JvmSuppressWildcards T) -> Any)? = null,
    itemContent: @Composable LazyItemScope.(item: T) -> Unit,
) {
    items(
        count = items.itemCount,
        key = items.itemKey(key),
        contentType = items.itemContentType(),
        itemContent = { index ->
            items[index]?.let {
                itemContent.invoke(this, it)
            }
        }
    )
}

@Composable
fun <T : Any> LazyColumnPaging(
    lazyPagingItems: LazyPagingItems<T>,
    state: LazyListState = rememberLazyListState(),
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    reverseLayout: Boolean = false,
    verticalArrangement: Arrangement.Vertical =
        if (!reverseLayout) Arrangement.Top else Arrangement.Bottom,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    flingBehavior: FlingBehavior = ScrollableDefaults.flingBehavior(),
    userScrollEnabled: Boolean = true,
    topContent: (LazyListScope.() -> Unit)? = null,
    bottomContent: (LazyListScope.() -> Unit)? = null,

    isSuccess: Boolean = lazyPagingItems.isSuccess(),

    Empty: (@Composable () -> Unit)? = null,
    Loading: (@Composable () -> Unit)? = null,
    key: ((item: T) -> Any)? = null,
    itemContent: @Composable LazyItemScope
    .(item: T) -> Unit,

    ) {

    LazyColumn (
        modifier,
        state,
        contentPadding,
        reverseLayout,
        verticalArrangement,
        horizontalAlignment,
        flingBehavior,
        userScrollEnabled,
    ) {
        topContent?.invoke(this)
        if (lazyPagingItems.isNotSuccess2()) {
            item {
                if (Loading != null) {
                    lazyPagingItems.ComposeDefault(
                        Loading = Loading,
                        Empty = Empty,
                    )
                } else {
                    lazyPagingItems.ComposeDefault(
                        Empty = Empty,
                    )
                }
            }
        }
        if (isSuccess) {
            items(lazyPagingItems, key = key, itemContent)
        }

        bottomContent?.invoke(this)
    }
}

@Composable
fun onStart(
    onStop: (() -> Unit)? = null,    // Send the 'stopped' analytics event
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    onStart: () -> Unit, // Send the 'started' analytics event
) {

    // Safely update the current lambdas when a new one is provided
    val currentOnStart by rememberUpdatedState(onStart)
    //val currentOnStop by rememberUpdatedState(onStop)

    // If `lifecycleOwner` changes, dispose and reset the effect
    DisposableEffect(lifecycleOwner) {
        // Create an observer that triggers our remembered callbacks
        // for sending analytics events
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_START) {
                currentOnStart()
            } else if (event == Lifecycle.Event.ON_STOP) {
                onStop?.invoke()
            }
        }

        // Add the observer to the lifecycle
        lifecycleOwner.lifecycle.addObserver(observer)

        // When the effect leaves the Composition, remove the observer
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

}