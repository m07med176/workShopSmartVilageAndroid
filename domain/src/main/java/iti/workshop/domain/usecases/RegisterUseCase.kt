package iti.workshop.domain.usecases

import iti.workshop.data.source.remote.models.regieter.RegisterBody
import iti.workshop.data.repository.AuthenticationRepositoryInterface

class RegisterUseCase(private val userRepositoryInterface: AuthenticationRepositoryInterface) {
    suspend operator fun invoke(body: RegisterBody)=userRepositoryInterface.regUser(body)
}