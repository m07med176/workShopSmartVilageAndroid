package iti.workshop.domain.usecases.authentication

import iti.workshop.data.repository.news.authentication.AuthenticationRepositoryInterface

class LogoutUseCase(private val _repo: AuthenticationRepositoryInterface) {

    operator fun invoke(){
        _repo.logout()
    }
}