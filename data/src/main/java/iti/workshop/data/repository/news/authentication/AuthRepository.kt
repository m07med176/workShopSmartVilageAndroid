package iti.workshop.data.repository.news.authentication

import iti.workshop.data.source.dto.User
import iti.workshop.data.source.remote.AuthRemoteDataSource
import iti.workshop.data.source.remote.models.login.LoginBody
import iti.workshop.data.source.remote.models.regieter.RegisterBody
import iti.workshop.data.source.shared.SharedManager


class AuthRepository(
    val shared: SharedManager,
    val remote: AuthRemoteDataSource
) : AuthenticationRepositoryInterface {
    override suspend fun regUser(body: RegisterBody): Boolean {
        val reg= remote.register(body)
        savedLoginData(User(email = body.email, name = body.displayName))
        return reg?.displayName!=null
    }

    override suspend fun loginUser(body: LoginBody):Boolean {
        val login=remote.loginUser(body)
        return login.registered!=null&&login.registered==true
    }

    override fun logout() {
        TODO("Not yet implemented")
    }
    private fun savedLoginData(user: User){
        shared.saveUser(user)
    }

}