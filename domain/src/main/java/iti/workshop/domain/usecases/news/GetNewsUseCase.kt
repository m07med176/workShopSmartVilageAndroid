package iti.workshop.domain.usecases.news

import iti.workshop.data.repository.news.NewsRepositoryInterface

class GetNewsUseCase(private val newsRepository: NewsRepositoryInterface) {

    suspend operator fun invoke(apiKey:String,country:String)=newsRepository.getNews(apiKey,country)

}