package iti.workshop.domain.usecases

import iti.workshop.domain.models.reg.RegBody
import iti.workshop.domain.models.reg.RegResponse
import iti.workshop.domain.repository.AuthenticationRepo
import iti.workshop.domain.repository.RepositoryInterface

class RegisterUser(private val userRepositoryInterface: AuthenticationRepo) {
    suspend operator fun invoke(body: RegBody)=userRepositoryInterface.regUser(body)
}