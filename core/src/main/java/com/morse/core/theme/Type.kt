package com.morse.core.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.morse.core.R

// Set of Material typography styles to start with

object MyFont {
    val mainFont = FontFamily(
        Font(R.font.oswald_regular, FontWeight.Normal),
        Font(R.font.oswald_bold, FontWeight.Bold),
        Font(R.font.oswald_medium, FontWeight.Medium),
        Font(R.font.oswald_bold, FontWeight.ExtraBold),
        Font(R.font.oswald_semibold, FontWeight.SemiBold),
    )

}



object MySize {



}
val lineHeight = 20.sp
val letterSpacing = 0.sp
val MyTypography = Typography(
    titleLarge = TextStyle(
        fontFamily = MyFont.mainFont,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
        color = MyColor.color_FFFFFF,
        lineHeight = lineHeight,
        textAlign = TextAlign.Start,
        textDirection = TextDirection.Content,
        letterSpacing = letterSpacing,

    ),
    titleMedium = TextStyle(
        fontFamily = MyFont.mainFont,
        fontSize = 15.sp,
        lineHeight = lineHeight,
        fontWeight = FontWeight.Medium,
        letterSpacing = letterSpacing,

    ),

    titleSmall = TextStyle(
        fontFamily = MyFont.mainFont,
        lineHeight = lineHeight,
        fontSize = 12.sp,
        fontWeight = FontWeight.Light,
        letterSpacing = letterSpacing

    ),
    bodyLarge = TextStyle(
        fontFamily = MyFont.mainFont,
        lineHeight = lineHeight,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = letterSpacing,
        ),
    bodyMedium = TextStyle(
        fontFamily = MyFont.mainFont,
        lineHeight = lineHeight,
        fontSize = 15.sp,
        fontWeight = FontWeight.Normal,
        letterSpacing = letterSpacing,
    ),

    bodySmall = TextStyle(
        fontFamily = MyFont.mainFont,
        fontSize = 12.sp,
        lineHeight = lineHeight,
        fontWeight = FontWeight.Light,
        letterSpacing = letterSpacing
    ),

    displayLarge = TextStyle(
        fontFamily = MyFont.mainFont,
        fontSize = 20.sp,
        lineHeight = lineHeight,
        fontWeight = FontWeight.Medium,
        letterSpacing = letterSpacing

    ),

    displayMedium = TextStyle(
        fontFamily = MyFont.mainFont,
        lineHeight = lineHeight,

        fontSize = 15.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = letterSpacing


    ),

    displaySmall = TextStyle(
        fontFamily = MyFont.mainFont,
        lineHeight = lineHeight,

        fontSize = 12.sp,
        fontWeight = FontWeight.Light,
        letterSpacing = letterSpacing


    ),

    headlineLarge = TextStyle(
        fontFamily = MyFont.mainFont,
        lineHeight = lineHeight,

        fontSize = 20.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = letterSpacing


    ),

    headlineMedium = TextStyle(
        fontFamily = MyFont.mainFont,
        lineHeight = lineHeight,

        fontSize = 15.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = letterSpacing


    ),

    headlineSmall = TextStyle(
        fontFamily = MyFont.mainFont,
        fontSize = 12.sp,
        lineHeight = lineHeight,

        fontWeight = FontWeight.Light,
        letterSpacing = letterSpacing


    ),

    labelLarge = TextStyle(
        fontFamily = MyFont.mainFont,
        fontSize = 20.sp,
        lineHeight = lineHeight,

        fontWeight = FontWeight.Medium,
        letterSpacing = letterSpacing


    ),
    labelMedium = TextStyle(
        fontFamily = MyFont.mainFont,
        fontSize = 15.sp,
        lineHeight = lineHeight,

        fontWeight = FontWeight.Normal,
        letterSpacing = letterSpacing


    ),
    labelSmall = TextStyle(
        fontFamily = MyFont.mainFont,
        fontSize = 12.sp,
        lineHeight = lineHeight,
        fontWeight = FontWeight.Light,
        letterSpacing = letterSpacing

    )

)