package iti.workshop.newApp.details


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import iti.workshop.domain.usecases.CheckFavoriteExist
import iti.workshop.domain.usecases.DeleteFavorite
import iti.workshop.domain.usecases.InsertFavorite

class DetailsViewModelFactory(
    private val insert: InsertFavorite,
    private val delete: DeleteFavorite,
    private val checkIsExist: CheckFavoriteExist
    ): ViewModelProvider.Factory{
    override fun <T:ViewModel> create(modelClass: Class<T>):T{
        if(modelClass.isAssignableFrom(DetailsViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return DetailsViewModel(insert, delete, checkIsExist) as T
        }
        throw IllegalArgumentException("UNKNOWN VIEW MODEL CLASS")
    }

}
