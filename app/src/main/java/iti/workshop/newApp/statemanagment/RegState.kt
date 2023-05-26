package iti.workshop.newApp.statemanagment

import iti.workshop.domain.models.reg.RegResponse

sealed class RegState{
    class Success(val data: Boolean):RegState()
    class Failure(val error:Throwable):RegState()
    object Loading : RegState()
}
