package iti.workshop.domain.usecases.authentication

import iti.workshop.data.source.remote.models.regieter.RegisterBody
import iti.workshop.data.repository.news.authentication.AuthenticationRepositoryInterface

class RegisterUseCase(private val _repo: AuthenticationRepositoryInterface) {
    suspend operator fun invoke(body: RegisterBody)=_repo.regUser(body)
}