package com.morse.domain.paginations

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.morse.domain.models.New


abstract class INewsPagingSource : PagingSource<Int, New>() {
    override fun getRefreshKey(state: PagingState<Int, New>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}