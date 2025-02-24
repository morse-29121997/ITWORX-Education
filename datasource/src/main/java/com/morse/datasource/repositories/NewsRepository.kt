package com.morse.datasource.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.morse.datasource.local.database.NewsDao
import com.morse.datasource.mappers.asDatabaseEntity
import com.morse.datasource.mappers.asDomain
import com.morse.datasource.remote.AllNewsRemotePagingSource
import com.morse.datasource.remote.HeadlineNewsRemotePagingSource
import com.morse.datasource.remote.NewsApis
import com.morse.domain.models.New
import com.morse.domain.repositories.INewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject


class NewsRepository @Inject constructor(
    private val api: NewsApis,
    private val db: NewsDao,
    private val scope: CoroutineScope
) :
    INewsRepository {

    override suspend fun isSaved(news: New): Boolean {
        return scope.async { db.isExist(news.url) }.await()
    }

    override fun saveFromWatchLater(news: New) {
        scope.launch { db.insertNews(news.asDatabaseEntity()) }
    }

    override fun deleteFromWatchLater(news: New) {
        scope.launch { db.delete(news.asDatabaseEntity().url) }
    }

    override suspend fun getWatchLater(): List<New> {
        return scope.async { db.getAllNews().map {
            it.asDomain()
        }  }.await()
    }

    override fun getTopHeadline(
        searchText: String?,
        country: String,
        category: ArrayList<String>,
    ): Pager<Int, New> {
        val headlinePaginationService = HeadlineNewsRemotePagingSource(
            api, searchText, country, category
        )
        return Pager(
            config = PagingConfig(pageSize = 10),
            initialKey = 1,
            pagingSourceFactory = { headlinePaginationService })
    }

    override fun getAllNews(
        searchText: String?,
        sources: ArrayList<String>,
    ): Pager<Int, New> {
        val headlinePaginationService = AllNewsRemotePagingSource(
            api, searchText, sources
        )
        return Pager(
            config = PagingConfig(pageSize = 10),
            initialKey = 1,
            pagingSourceFactory = { headlinePaginationService })
    }

}