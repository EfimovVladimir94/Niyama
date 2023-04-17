package ktor.models

import kotlinx.serialization.Serializable

@Serializable
data class KtorLoginDetails(
    val email: String,
    val password: String
)