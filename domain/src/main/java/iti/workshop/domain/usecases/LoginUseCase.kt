package iti.workshop.domain.usecases

import iti.workshop.domain.models.MappedLoginBody
import iti.workshop.data.repository.AuthenticationRepositoryInterface
import iti.workshop.data.source.remote.models.login.LoginBody

class LoginUseCase( private val userRepositoryInterface: AuthenticationRepositoryInterface) {
    suspend operator fun invoke(body: LoginBody)=userRepositoryInterface.loginUser(body)

}