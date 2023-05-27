package iti.workshop.domain.usecases

import iti.workshop.data.repository.NewsRepositoryInterface

class GetNewsUseCase(private val newsRepository: NewsRepositoryInterface) {

    suspend operator fun invoke(apiKey:String,country:String)=newsRepository.getNews(apiKey,country)

}