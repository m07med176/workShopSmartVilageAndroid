package iti.workshop.domain.usecases.news

import iti.workshop.data.repository.news.NewsRepository
import iti.workshop.data.repository.news.NewsRepositoryInterface
import kotlinx.coroutines.flow.Flow

class CheckFavoriteExistUseCase(private val _repo: NewsRepositoryInterface) {

    operator fun invoke(title:String):Flow<Boolean> = _repo.isExists(title)
}