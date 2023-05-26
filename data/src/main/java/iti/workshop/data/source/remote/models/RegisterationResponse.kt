package iti.workshop.data.source.remote.models

data class RegisterationResponse(
    var kind: String? = null,
    var idToken: String? = null,
    var displayName: String? = null,
    var email: String? = null,
    var refreshToken: String? = null,
    var expiresIn: String? = null,
    var localId: String? = null
)