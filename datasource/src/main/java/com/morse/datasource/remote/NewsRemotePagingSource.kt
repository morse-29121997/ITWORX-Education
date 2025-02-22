package com.morse.datasource.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.morse.datasource.models.New
import java.io.IOException

class NewsRemotePagingSource(
    private val newsApis: NewsApis,
    private val searchText: String?,
    private val country: String,
    private val category: ArrayList<String>
) : PagingSource<Int, New>() {

    override fun getRefreshKey(state: PagingState<Int, New>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, New> {
        val page = params.key ?: 1
        val pageSize = params.loadSize
        return try {
            val response = newsApis.getTopHeadline(searchText, country, category, page, pageSize)
            if (response.isSuccessful) {
                val articles = response.body()?.articles ?: emptyList()
                val nextKey = if (articles.size < pageSize) null else page + 1
                val prevKey = if (page == 1) null else page - 1
                LoadResult.Page(articles, prevKey, nextKey)
            } else {
                LoadResult.Error(retrofit2.HttpException(response))
            }
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: retrofit2.HttpException) {
            LoadResult.Error(e)
        }
    }
}