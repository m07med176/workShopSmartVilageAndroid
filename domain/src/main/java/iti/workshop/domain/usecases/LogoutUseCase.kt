package iti.workshop.domain.usecases

import iti.workshop.data.repository.IRepository

class LogoutUseCase(private val _repo: IRepository) {

    operator fun invoke(){
        _repo.logout()
    }
}