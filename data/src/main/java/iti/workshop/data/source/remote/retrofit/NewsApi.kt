package iti.workshop.data.source.remote.retrofit


import iti.workshop.data.source.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    suspend fun getNews(@Query("apiKey")apiKey:String, @Query("country")country:String): NewsResponse
}