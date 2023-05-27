package iti.workshop.data.source.remote.retrofit


import iti.workshop.data.source.remote.models.news.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET
    suspend fun getNews(@Query("apiKey")apiKey:String, @Query("country")country:String): NewsResponse
}