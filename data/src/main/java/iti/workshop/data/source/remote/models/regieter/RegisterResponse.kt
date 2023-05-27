package iti.workshop.data.source.remote.models.regieter

data class RegisterResponse(val displayName: String,
                            val email: String,
                            val expiresIn: String,
                            val idToken: String,
                            val kind: String,
                            val localId: String,
                            val refreshToken: String)
