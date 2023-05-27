package iti.workshop.data.source.remote.models.login

data class Login(
    val displayName: String?=null,
    val email: String?=null,
    val expiresIn: String?=null,
    val idToken: String?=null,
    val kind: String?=null,
    val localId: String?=null,
    val refreshToken: String?=null,
    val registered: Boolean?=false
)