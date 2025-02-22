package com.morse.domain.models

data class New (
    val sourceName: String,
    val author: String ?= null,
    val title: String,
    val url: String,
    val urlToImage: String?= null,
    val publishedAt: String
)