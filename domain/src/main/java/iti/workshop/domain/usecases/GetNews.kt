package iti.workshop.domain.usecases

import iti.workshop.domain.repository.RepositoryInterface

class GetNews(private val newsRepository:RepositoryInterface) {

    suspend operator fun invoke(apiKey:String,country:String)=newsRepository.getNews(apiKey,country)

}