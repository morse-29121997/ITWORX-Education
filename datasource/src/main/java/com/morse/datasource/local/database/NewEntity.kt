package com.morse.datasource.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_news")
data class NewEntity (
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0 ,
    val author: String,
    val title: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val sourceName: String,
)