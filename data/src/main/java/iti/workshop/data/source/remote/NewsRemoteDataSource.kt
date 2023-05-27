package iti.workshop.data.source.remote

import iti.workshop.data.source.dto.NewsResponse
import iti.workshop.data.source.remote.retrofit.NewsApi

import kotlinx.coroutines.flow.Flow

class NewsRemoteDataSource(private  val api:NewsApi):INewsRemoteDataSource {
    override suspend fun getNews(apikey:String,countryName:String): NewsResponse {
        return api.getNews(apikey,countryName)
    }
}