package iti.workshop.data.source.repository

import iti.workshop.data.repository.NewsRepositoryInterface
import iti.workshop.data.source.remote.NewsRemoteDataSource
import iti.workshop.data.source.remote.models.news.Article

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepository( val remote:NewsRemoteDataSource): NewsRepositoryInterface {
    override suspend fun getNews(apiKey: String, country: String): Flow<List<Article>> = flow {
        emit(remote.getNews(apiKey,country).articles)
    }
}