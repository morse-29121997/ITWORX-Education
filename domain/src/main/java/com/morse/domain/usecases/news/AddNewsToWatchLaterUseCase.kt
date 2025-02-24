package com.morse.domain.usecases.news

import com.morse.domain.base.UseCase
import com.morse.domain.models.New
import com.morse.domain.repositories.INewsRepository
import javax.inject.Inject

class AddNewsToWatchLaterUseCase @Inject constructor (private val repo: INewsRepository) : UseCase<New, Unit>() {
    override fun execute(input: New) {
        repo.saveFromWatchLater(input)
    }
}