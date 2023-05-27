package iti.workshop.domain.models

data class MappedLoginBody( val email: String,
                            val password: String,
                            val returnSecureToken: Boolean)
