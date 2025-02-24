package com.morse.datasource.remote

import com.morse.datasource.mappers.asDomain
import com.morse.domain.models.New as DomainNew
import com.morse.domain.paginations.INewsPagingSource
import java.io.IOException
import javax.inject.Inject


class AllNewsRemotePagingSource @Inject constructor(
    private val newsApis: NewsApis,
    private val searchText: String?,
    private val sources: ArrayList<String>
) : INewsPagingSource() {
    private var totalCurrentNews : Int = 0
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DomainNew> {
        val page = params.key ?: 1
        val pageSize = params.loadSize
        return try {
            val response = newsApis.getAll(searchText, page, sources, pageSize)
            if (response.isSuccessful) {
                val articles = response.body()?.articles?.map { it.asDomain() } ?: emptyList()
                totalCurrentNews +=articles.size
                val nextKey = if(response.body()?.totalResults == 0) null else if (totalCurrentNews < (response.body()?.totalResults ?: 0)) null else page + 1
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