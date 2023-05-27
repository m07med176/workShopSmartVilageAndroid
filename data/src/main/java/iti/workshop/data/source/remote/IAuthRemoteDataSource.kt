package iti.workshop.data.source.remote

import iti.workshop.data.source.remote.models.login.Login
import iti.workshop.data.source.remote.models.login.LoginBody
import iti.workshop.data.source.remote.models.regieter.RegisterBody
import iti.workshop.data.source.remote.models.regieter.RegisterResponse


interface IAuthRemoteDataSource{
    suspend fun register(
        body: RegisterBody
    ): RegisterResponse

    suspend fun loginUser(
       body: LoginBody
    ): Login
}