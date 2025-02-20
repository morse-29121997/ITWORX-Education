package com.morse.onboarding.onboarding

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.morse.core.theme.MyColor
import com.morse.core.theme.MyTypography
import com.morse.core.ui.Indicators
import com.morse.core.ui.MyButtonGrey
import com.morse.core.ui.MyButtonMain
import com.morse.onboarding.R
import kotlinx.coroutines.launch
import java.util.Locale

@Composable
fun OnBoardingScreen(onFinish: () -> Unit = {}) {
    val initialPage = remember {
        0
    }
    val items = OnBoardingItem.get()
    val statePager = rememberPagerState(initialPage = initialPage) { items.size }
    val scope = rememberCoroutineScope()
    val locale = Locale.getDefault().language
    Box(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.on_boarding_bg),
                contentDescription = null,
                modifier = Modifier.size(2000.dp, 2000.dp),
                contentScale = ContentScale.FillBounds
            )
        }

        ConstraintLayout(
            Modifier
                .fillMaxSize()
                .padding(vertical = 20.dp)
        ) {
            val (pager, actions) = createRefs()
            Column(
                Modifier
                    .fillMaxWidth()
                    .constrainAs(pager) {
                        linkTo(top = parent.top, bottom = actions.top)
                        width = Dimension.matchParent
                    }
                    .padding(bottom = 15.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.7F)
                ) {
                    HorizontalPager(
                        state = statePager,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopStart),
                    ) { page ->
                        OnBoardingItem(
                            items[page]
                        )
                    }
                }

                Indicators(
                    size = items.size,
                    index = statePager.currentPage,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                )
            }
            if (statePager.currentPage == items.size - 1) {
                MyButtonMain(
                    stringResourceId = R.string.login,
                    modifier = Modifier
                        .padding(horizontal =  20.dp)
                        .fillMaxWidth()
                        .constrainAs(actions) {
                            bottom.linkTo(parent.bottom)
                            width = Dimension.matchParent
                        },
                    isValid = true,
                    onValidClick = { onFinish.invoke() },
                )
            } else {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .constrainAs(actions) {
                            bottom.linkTo(parent.bottom)
                            width = Dimension.matchParent
                        }, horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    MyButtonGrey(
                        stringResourceId = R.string.skip,
                        onClick = onFinish,
                        modifier = Modifier.padding(horizontal = 20.dp),

                        )

                    Box(Modifier.fillMaxWidth()) {
                        MyButtonMain(
                            stringResourceId = R.string.next,
                            modifier = Modifier
                                .padding(horizontal = 20.dp)
                                .align(CenterEnd),
                        ) {
                            scope.launch {
                                statePager.animateScrollToPage(statePager.currentPage + 1)
                            }
                        }

                    }
                }
            }
        }
    }

}
@Composable
fun OnBoardingItem(
    item: OnBoardingItem
) {
    Column(
        horizontalAlignment = Alignment.Start ,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier,
    ) {

        Text(
            modifier = Modifier.padding(horizontal = 10.dp , vertical = 10.dp),
            text = stringResource(id = item.text),
            textAlign = TextAlign.Start,
            color = MyColor.color_FFFFFF,
            style = MyTypography.titleLarge,
            lineHeight = 60.sp,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )

        Image(
            painter = painterResource(item.image),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .height(400.dp)
        )


    }
}