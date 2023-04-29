package ktor

import kotlinx.serialization.Serializable

@Serializable
data class KtorLoginRequest (
    val email: String,
    val password: String
)