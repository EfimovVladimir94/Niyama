import models.AuthResponse

interface AuthRepository {
    suspend fun login(login: String, password: String): AuthResponse
    fun isUserLoggedIn(): Boolean
}