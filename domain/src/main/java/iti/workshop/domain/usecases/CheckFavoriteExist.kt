package iti.workshop.domain.usecases

import iti.workshop.data.repository.IRepository
import kotlinx.coroutines.flow.Flow

class CheckFavoriteExist(private val _repo: IRepository) {

    operator fun invoke(title:String):Flow<Boolean> = _repo.isExists(title)
}