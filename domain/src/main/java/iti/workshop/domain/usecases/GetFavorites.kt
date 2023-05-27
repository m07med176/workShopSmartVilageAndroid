package iti.workshop.domain.usecases

import iti.workshop.data.repository.IRepository
import iti.workshop.data.source.dto.Article
import kotlinx.coroutines.flow.Flow

class GetFavorites(private val _repo: IRepository) {
    operator fun invoke(): Flow<List<Article>> = _repo.getArticles()
}