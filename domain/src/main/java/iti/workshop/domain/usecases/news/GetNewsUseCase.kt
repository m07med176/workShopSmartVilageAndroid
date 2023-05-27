package iti.workshop.domain.usecases.news

import iti.workshop.data.repository.news.NewsRepositoryInterface

class GetNewsUseCase(private val newsRepository: NewsRepositoryInterface) {

    suspend operator fun invoke(apiKey:String = "34c6c06803ef436d8778bd668d5cdb65",country:String="us")=newsRepository.getNews(apiKey,country)

}