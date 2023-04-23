package ktor

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import ktor.models.KtorAuthorization
import models.Profile

class KtorProfileDataSource(private val httpClient: HttpClient) {
    suspend fun fetchProfileDetails(): Profile {
        return Profile(name = "Test", email = "test@example.com", password = "password")
    }

    suspend fun login(): String {
        return httpClient.post {
            header("Content-Type", "application/json")
            url {
                path("/api/v1/auth/login")
                setBody(KtorAuthorization("test@mail.ru", "test@mail.ru"))
            }
        }.body()
    }
}