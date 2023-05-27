package iti.workshop.data.source.remote.retrofit

import iti.workshop.data.source.Constants
import iti.workshop.data.source.remote.models.RegBody
import iti.workshop.data.source.remote.models.RegisterationResponse
import iti.workshop.data.source.remote.models.login.Login
import iti.workshop.data.source.remote.models.login.LoginBody
import iti.workshop.data.source.remote.models.regieter.RegisterBody
import iti.workshop.data.source.remote.models.regieter.RegisterResponse

import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApi {
    @POST(Constants.REGISTER_API_URL)

    suspend fun register(
        @Body body: RegisterBody, @Query("key") apikey: String = Constants.AUTH_API_KEY
    ): RegisterResponse

    @POST(Constants.LOGIN_API_URL + "?4564654" + Constants.AUTH_API_KEY)
    suspend fun loginUser(
        @Body body: LoginBody
    ): Login
}