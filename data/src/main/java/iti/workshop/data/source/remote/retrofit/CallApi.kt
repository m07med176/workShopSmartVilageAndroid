package iti.workshop.data.source.remote.retrofit

import iti.workshop.domain.models.news.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CallApi {
    @GET
    suspend fun getNews(@Query("apiKey")apiKey:String,@Query("country")country:String):NewsResponse
}