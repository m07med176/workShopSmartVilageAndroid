package iti.workshop.domain.models.login

data class LoginBody(
    val email: String,
    val password: String,
    val returnSecureToken: Boolean
)
