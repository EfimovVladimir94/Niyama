import ktor.KtorAuthDataSource
import ktor.KtorLoginRequest
import models.AuthResponse

class AuthRepositoryImpl (
    private val ktorAuthDataSource: KtorAuthDataSource
): AuthRepository {

    override suspend fun login(login: String, password: String): AuthResponse {
        return ktorAuthDataSource.performLogin(KtorLoginRequest(login, password))
    }
}