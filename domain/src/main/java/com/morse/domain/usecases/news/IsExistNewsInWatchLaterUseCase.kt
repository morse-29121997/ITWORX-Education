package com.morse.domain.usecases.news

import com.morse.domain.base.UseCase
import com.morse.domain.models.New
import com.morse.domain.repositories.INewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class IsExistNewsInWatchLaterUseCase @Inject constructor(private val repo: INewsRepository) : UseCase<New, Flow<Boolean>>() {
    override fun execute(input: New) : Flow<Boolean>{
       return flow {
          val isSaved = repo.isSaved(input)
            emit(isSaved)
       }
    }
}