package iti.workshop.data.source.repository

import android.content.Context
import iti.workshop.data.repository.AuthenticationRepositoryInterface
import iti.workshop.data.source.remote.AuthRemoteDataSource
import iti.workshop.data.source.remote.models.login.LoginBody
import iti.workshop.data.source.remote.models.regieter.RegisterBody


class AuthRepository(

    val remote: AuthRemoteDataSource
) : AuthenticationRepositoryInterface {
    override suspend fun regUser(body: RegisterBody): Boolean {
        val reg= remote.register(body)
        return reg?.displayName!=null
    }

    override suspend fun loginUser(body: LoginBody):Boolean {
       var flag=false
        val login=remote.loginUser(body)
        return login.registered!=null&&login.registered==true
    }


}