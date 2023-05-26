package iti.workshop.data.source.remote.retrofit

import iti.workshop.data.source.Constants
import iti.workshop.domain.models.news.NewsResponse
import iti.workshop.domain.models.reg.RegBody
import iti.workshop.domain.models.reg.RegResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CallApi {
    @GET
    suspend fun getNews(@Query("apiKey")apiKey:String,@Query("country")country:String):NewsResponse

    @POST(Constants.REG_BASE_UR + "?" + Constants.API_KEY)
    suspend fun register(
        @Body body: RegBody

    ): RegResponse
}