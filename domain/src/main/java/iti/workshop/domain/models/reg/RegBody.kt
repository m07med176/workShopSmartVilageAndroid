package iti.workshop.domain.models.reg

data class RegBody(
    val displayName: String,
    val email: String,
    val password: String,
    val returnSecureToken: Boolean
)