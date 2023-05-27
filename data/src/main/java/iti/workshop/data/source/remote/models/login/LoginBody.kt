package iti.workshop.data.source.remote.models.login

data class LoginBody(
    val email: String,
    val password: String,
    val returnSecureToken: Boolean
)
