package com.morse.domain.usecases.news

import com.morse.domain.base.UseCase
import com.morse.domain.models.New
import com.morse.domain.repositories.INewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllNewsInWatchLaterUseCase @Inject constructor (private val repo: INewsRepository) : UseCase<Unit, Flow<List<New>>>() {
    override fun execute(input: Unit) : Flow<List<New>>{
      return  flow{
          val list = repo.getWatchLater()
          emit(list)
      }
    }
}