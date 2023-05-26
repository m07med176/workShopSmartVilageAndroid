package iti.workshop.domain.models.reg

data class RegResponse(
    val displayName: String,
    val email: String,
    val expiresIn: String,
    val idToken: String,
    val kind: String,
    val localId: String,
    val refreshToken: String
)