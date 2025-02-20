package com.morse.core.ui

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

