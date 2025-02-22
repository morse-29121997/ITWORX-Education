package com.morse.domain.repositories

import androidx.paging.Pager
import androidx.paging.PagingSource
import com.morse.domain.models.New

interface INewsRepository {

    suspend fun getWatchLater(): List<New>

   suspend fun isSaved(news: New): Boolean

    fun saveFromWatchLater(news: New)

    fun deleteFromWatchLater(news: New)

    fun getTopHeadline(
        searchText: String?,
        country: String,
        category: ArrayList<String>,
    ): Pager<Int, New>

    fun getAllNews(
        searchText: String? = null,
        sources: ArrayList<String>,
    ): Pager<Int, New>
}