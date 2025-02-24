package com.morse.domain.usecases.news

import androidx.paging.PagingData
import com.morse.domain.base.UseCase
import com.morse.domain.models.New
import com.morse.domain.repositories.INewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetHeadlineNewsUseCase @Inject constructor(private val repo: INewsRepository ) :
    UseCase<GetHeadlineNewsUseCase.Companion.Input, Flow<PagingData<New>>>() {
    companion object {
        data class Input(
            val searchText: String?,
            val country: String,
            val category: ArrayList<String>
        )
    }

    override fun execute(input: Input): Flow<PagingData<New>> {
      return repo.getTopHeadline(input.searchText, input.country, input.category).flow
    }
}