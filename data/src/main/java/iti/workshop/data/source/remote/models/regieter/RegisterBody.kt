package iti.workshop.data.source.remote.models.regieter

data class RegisterBody(  val displayName: String,
                          val email: String,
                          val password: String,
                          val returnSecureToken: Boolean)
