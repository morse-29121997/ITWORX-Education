package com.morse.domain.repositories

import com.morse.domain.models.New

interface INewsRepository {

    suspend fun getTopHeadline(
        searchText: String?,
        country: String,
        category: ArrayList<String>,
        page: Int,
        pageSize: Int,
    ): List<New>

    suspend fun getAllNews(
        searchText: String? = null,
        country: String,
        category: ArrayList<String>,
        page: Int,
        pageSize: Int,
    ): List<New>
}