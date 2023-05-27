package iti.workshop.domain.usecases.authentication

import iti.workshop.data.repository.news.authentication.AuthenticationRepositoryInterface
import iti.workshop.data.source.remote.models.login.LoginBody

class LoginUseCase( private val userRepositoryInterface: AuthenticationRepositoryInterface) {
    suspend operator fun invoke(body: LoginBody)=userRepositoryInterface.loginUser(body)

}