package ktor

import io.ktor.client.*
import models.Profile

class KtorProfileDataSource(val httpClient: HttpClient) {
    suspend fun fetchProfileDetails(): Profile {
        return Profile(name = "Test", email = "test@example.com", password = "password")
    }
}