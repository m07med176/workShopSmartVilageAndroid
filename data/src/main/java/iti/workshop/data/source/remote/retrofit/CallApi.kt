package iti.workshop.data.source.remote.retrofit

import iti.workshop.data.source.Constants
import iti.workshop.data.source.remote.models.RegBody
import iti.workshop.data.source.remote.models.RegisterationResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface CallApi {
    @POST(Constants.REGISTER_API_URL + "?" + Constants.REGISTER_API_KEY)
    suspend fun register(
        @Body body: RegBody

    ): RegisterationResponse
}