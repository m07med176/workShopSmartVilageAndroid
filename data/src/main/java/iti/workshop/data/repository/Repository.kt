package iti.workshop.data.repository

import iti.workshop.data.source.remote.RemoteDataSource
import iti.workshop.data.source.remote.retrofit.RetrofitInstance
import iti.workshop.domain.models.news.Article
import iti.workshop.domain.repository.RepositoryInterface
import iti.workshop.domain.models.news.NewsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repository(
    val remoteDAtaSource:RetrofitInstance
) : RepositoryInterface {


    override suspend fun getNews(apiKey: String, country: String): Flow<List<Article>> = flow {
        emit(remoteDAtaSource.api.getNews(apiKey,country).articles)
    }
}