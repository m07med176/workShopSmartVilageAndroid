package iti.workshop.data.repository

import iti.workshop.data.source.remote.models.login.LoginBody
import iti.workshop.data.source.remote.models.regieter.RegisterBody


interface AuthenticationRepositoryInterface {
    suspend fun regUser(body: RegisterBody):Boolean
    suspend fun loginUser(body: LoginBody):Boolean
}