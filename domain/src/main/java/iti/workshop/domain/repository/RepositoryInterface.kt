package iti.workshop.domain.repository

import iti.workshop.domain.models.news.Article
import iti.workshop.domain.models.news.NewsResponse
import kotlinx.coroutines.flow.Flow

interface RepositoryInterface {
    suspend fun getNews(apiKey:String, country:String): Flow<List<Article>>
}