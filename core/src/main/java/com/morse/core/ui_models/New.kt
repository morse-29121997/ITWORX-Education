package com.morse.core.ui_models

import androidx.compose.runtime.mutableStateOf

data class New(
    val sourceName: String,
    val author: String ?= null,
    val title: String,
    val url: String,
    val urlToImage: String ?= null,
    val publishedAt: String,
) {
    val isWatchedLater = mutableStateOf(false)
}