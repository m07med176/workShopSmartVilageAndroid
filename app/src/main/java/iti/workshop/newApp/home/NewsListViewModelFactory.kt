package iti.workshop.newApp.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NewsListViewModelFactory(
   // private val repository: Repository
    ): ViewModelProvider.Factory{
    override fun <T:ViewModel> create(modelClass: Class<T>):T{
        if(modelClass.isAssignableFrom(NewsListViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return NewsListViewModel() as T
        }
        throw IllegalArgumentException("UNKNOWN VIEW MODEL CLASS")
    }

}
