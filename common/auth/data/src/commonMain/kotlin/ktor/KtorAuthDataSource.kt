package ktor

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import models.AuthResponse

class KtorAuthDataSource(
    private val httpClient: HttpClient
) {

    suspend fun performLogin(request: KtorLoginRequest): AuthResponse {
        return httpClient.post {
            header("Content-Type", "application/json")
            url {
                path("/api/v1/auth/login")
                setBody(request)
            }
        }.body()
    }
}