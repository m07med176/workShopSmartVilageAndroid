package iti.workshop.newApp.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import iti.workshop.data.source.dto.Article
import iti.workshop.domain.usecases.CheckFavoriteExist
import iti.workshop.domain.usecases.DeleteFavorite
import iti.workshop.domain.usecases.InsertFavorite
import iti.workshop.domain.utils.DataResponseState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class DetailsViewModel(
    val insert: InsertFavorite,
    val delete:DeleteFavorite,
    val checkIsExist: CheckFavoriteExist
)
    :ViewModel() {

    private val _isExist =  MutableStateFlow<Boolean>(false)
    val isExist: StateFlow<Boolean>
    get() = _isExist

    fun insertArticle(article: Article){
        viewModelScope.launch {
            insert.invoke(article)
        }
    }

    fun removeArticle(article: Article){
        viewModelScope.launch {
            delete.invoke(article)
        }
    }
    fun checkIfFavoriteExist(title:String?){
        viewModelScope.launch {
            title?.let {
                checkIsExist.invoke(it).catch {
                    _isExist.value = false
                }.collect{
                    _isExist.value = it
                }
            }



        }
    }
}