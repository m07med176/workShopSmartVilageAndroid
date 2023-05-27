package iti.workshop.domain.usecases.news

import iti.workshop.data.repository.news.NewsRepositoryInterface
import iti.workshop.data.source.dto.Article

class InsertFavoriteUseCase(private val _repo: NewsRepositoryInterface) {

    suspend operator fun invoke(article: Article){
        _repo.insertArticle(article)
    }

}