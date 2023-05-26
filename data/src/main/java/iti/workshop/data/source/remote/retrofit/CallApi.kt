package iti.workshop.data.source.remote.retrofit

import iti.workshop.data.source.Constants
import iti.workshop.data.source.remote.models.RegisterationResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface CallApi {
    @POST(Constants.REGISTER_API_URL + "?" + Constants.REGISTER_API_KEY)
    suspend fun register(
        //  @Query("key") key:String
    ): RegisterationResponse
}