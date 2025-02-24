package com.morse.domain.usecases.news

import androidx.paging.PagingData
import com.morse.domain.base.UseCase
import com.morse.domain.models.New
import com.morse.domain.repositories.INewsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllNewsUseCase @Inject constructor(private val repo: INewsRepository) :
    UseCase<GetAllNewsUseCase.Companion.Input, Flow<PagingData<New>>>() {
    companion object {
        data class Input(
            val searchText: String?,
            val sources: ArrayList<String>
        )
    }

    override fun execute(input: Input): Flow<PagingData<New>> {
        return repo.getAllNews(input.searchText, input.sources).flow
    }
}