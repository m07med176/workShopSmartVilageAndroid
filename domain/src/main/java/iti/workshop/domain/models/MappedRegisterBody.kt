package iti.workshop.domain.models

data class MappedRegisterBody( val displayName: String,
                               val email: String,
                               val password: String,
                               val returnSecureToken: Boolean)
