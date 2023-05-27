package iti.workshop.domain.usecases

import iti.workshop.data.repository.IRepository
import iti.workshop.data.source.dto.Article

class InsertFavoriteUseCase(private val _repo: IRepository) {

    suspend operator fun invoke(article: Article){
        _repo.insertArticle(article)
    }

}