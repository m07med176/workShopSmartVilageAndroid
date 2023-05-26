package iti.workshop.domain.usecases

import iti.workshop.domain.models.reg.RegBody
import iti.workshop.domain.models.reg.RegResponse
import iti.workshop.domain.repository.RepositoryInterface

class RegisterUser(private val newsRepository: RepositoryInterface) {
    suspend operator fun invoke(body: RegBody)=newsRepository.regUser(body)
}