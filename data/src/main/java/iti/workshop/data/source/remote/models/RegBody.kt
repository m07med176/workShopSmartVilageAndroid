package iti.workshop.data.source.remote.models

data class RegBody(
    val displayName: String,
    val email: String,
    val password: String,
    val returnSecureToken: Boolean
)