package iti.workshop.data.source.remote


import iti.workshop.data.source.remote.models.news.NewsResponse
import kotlinx.coroutines.flow.Flow

interface INewsRemoteDataSource {
    suspend fun getNews(apikey:String,countryName:String): NewsResponse
}