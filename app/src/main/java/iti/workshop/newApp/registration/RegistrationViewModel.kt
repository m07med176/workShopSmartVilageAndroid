package iti.workshop.newApp.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import iti.workshop.data.repository.Repository
import iti.workshop.domain.models.reg.RegBody
import iti.workshop.domain.usecases.RegisterUser
import iti.workshop.newApp.statemanagment.RegState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class RegistrationViewModel(private val getReg:RegisterUser,private val body: RegBody):ViewModel() {
    private val _regbool: MutableStateFlow<RegState> = MutableStateFlow(RegState.Loading)
    val regbool: StateFlow<RegState> = _regbool
    fun regUser(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _regbool.value=RegState.Success(getReg(body))
            }catch (e:Exception){
                _regbool.value=RegState.Failure(e)
            }
        }
    }
    class RegistrationViewModelFactory(private val getReg:RegisterUser,private val body: RegBody): ViewModelProvider.Factory{
        override fun <T:ViewModel> create(modelClass: Class<T>):T{
            if(modelClass.isAssignableFrom(RegistrationViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return RegistrationViewModel(getReg,body) as T
            }
            throw IllegalArgumentException("UNKNOWN VIEW MODEL CLASS")
        }

}}

//private val _homeList: MutableStateFlow<HomeState> = MutableStateFlow(HomeState.Loading)
//    val homeList: StateFlow<HomeState> = _homeList