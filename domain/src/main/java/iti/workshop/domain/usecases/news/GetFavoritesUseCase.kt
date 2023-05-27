package iti.workshop.domain.usecases.news

import iti.workshop.data.repository.news.NewsRepositoryInterface
import iti.workshop.data.source.dto.Article
import kotlinx.coroutines.flow.Flow

class GetFavoritesUseCase(private val _repo: NewsRepositoryInterface) {
    operator fun invoke(): Flow<List<Article>> = _repo.getArticles()
}