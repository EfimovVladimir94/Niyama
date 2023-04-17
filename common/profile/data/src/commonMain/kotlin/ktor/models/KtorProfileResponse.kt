package ktor.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import models.Profile

@Serializable
data class KtorProfileDetails (
    @SerialName("name") val name: String,
    @SerialName("email") val email: String,
    @SerialName("phone") val phone: String,
    @SerialName("birthday") val birthday: String,
    @SerialName("imageUrl") val imageUrl: String
)

fun KtorProfileDetails.mapToProfile(): Profile =
    Profile(
        name = name,
        email = email,
        password = ""
    )