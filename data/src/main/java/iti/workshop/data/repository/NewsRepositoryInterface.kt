package iti.workshop.data.repository

import iti.workshop.data.source.remote.models.news.Article


import kotlinx.coroutines.flow.Flow

interface NewsRepositoryInterface {
    suspend fun getNews(apiKey:String, country:String): Flow<List<Article>>

}