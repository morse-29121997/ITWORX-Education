package com.morse.onboarding.preferences

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.morse.core.theme.MyColor
import com.morse.core.theme.MyTypography
import com.morse.core.ui.MyButtonGrey
import com.morse.core.ui.MyButtonMain
import com.morse.onboarding.R
import com.morse.onboarding.preferences.select_preferences.SelectPreferences

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreferenceScreen(onSaveSuccess : () -> Unit = {}) {
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
            val (content, actions) = createRefs()
            Column(
                Modifier
                    .fillMaxWidth()
                    .constrainAs(content) {
                        linkTo(top = parent.top, bottom = actions.top)
                        width = Dimension.matchParent
                        verticalBias =0f
                    }
                    .padding(bottom = 50.dp),
            ) {
                TopBar{}
                SelectPreferences()
            }
            if (true) {
                MyButtonMain(
                    stringResourceId = R.string.save,
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                        .constrainAs(actions) {
                            bottom.linkTo(parent.bottom)
                            width = Dimension.matchParent
                        },
                    isValid = true,
                    onValidClick = { },
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
                        stringResourceId = R.string.back,
                        onClick = { },
                        modifier = Modifier.padding(horizontal = 20.dp),

                        )

                    Box(Modifier.fillMaxWidth()) {
                        MyButtonMain(
                            stringResourceId = R.string.next,
                            modifier = Modifier
                                .padding(horizontal = 20.dp)
                                .align(CenterEnd),
                        ) {

                        }

                    }
                }
            }
        }
    }
}

@Composable
fun TopBar(onClose: () -> Unit) {
    Column(
        Modifier
            .background(Color.Unspecified)
            .padding(top = 10.dp, bottom = 0.dp)
    ) {
        Row(
            modifier = Modifier,
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
            LinearProgressIndicator(
                progress = { 1f },
                modifier = Modifier
                    .weight(6F)
                    .height(6.dp)
                    .padding(start = 10.dp, end = 10.dp),
                color = MyColor.color_af0909,
                trackColor = MyColor.color_FFFFFF
            )

            Row(
                modifier = Modifier.weight(1F),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "2",
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    style = MyTypography.bodyMedium,
                    color = MyColor.color_FFFFFF
                )

                Text(
                    text = stringResource(id = R.string.of),
                    fontWeight = FontWeight.Normal,
                    fontSize = 13.sp,
                    style = MyTypography.bodyMedium,
                    color = MyColor.color_af0909,
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
                Text(
                    text = "2",
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    style = MyTypography.bodyMedium,
                    color = MyColor.color_FFFFFF
                )
            }
        }

        Text(
            text = stringResource(R.string.please_Select_preference),
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth()
                .padding(vertical = 15.dp , horizontal = 10.dp),
            color = MyColor.color_FFFFFF,
            maxLines = Int.MAX_VALUE,
            textAlign = TextAlign.Start,
            style = MyTypography.titleLarge,
            lineHeight = 29.sp
        )

    }

}