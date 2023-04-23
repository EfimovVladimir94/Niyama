package ktor.models

import kotlinx.serialization.Serializable

@Serializable
data class KtorAuthorization(
    val email: String,
    val password: String
)