package iti.workshop.newApp.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import iti.workshop.data.source.remote.models.login.LoginBody
import iti.workshop.data.source.remote.models.regieter.RegisterBody
import iti.workshop.domain.usecases.authentication.LoginUseCase
import iti.workshop.domain.usecases.authentication.RegisterUseCase
import iti.workshop.newApp.di.AppDependency
import iti.workshop.newApp.states.LoginState
import iti.workshop.newApp.states.RegisterState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel (private val loginUser: LoginUseCase): ViewModel() {
    private val _loginStatus: MutableStateFlow<LoginState> = MutableStateFlow(LoginState.Loading)
    val loginStatus: StateFlow<LoginState> = _loginStatus
    fun logInUser(body: LoginBody){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _loginStatus.value= LoginState.Success(loginUser(body))
            }catch (e: Exception){
                _loginStatus.value= LoginState.Failure(e)
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {

                LoginViewModel(
                    loginUser = AppDependency.loginUseCase
                )
            }
        }
    }


}