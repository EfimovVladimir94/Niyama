import ktor.KtorAuthDataSource
import ktor.KtorLoginRequest
import models.AuthResponse
import settings.SettingsAuthDataSource

class AuthRepositoryImpl (
    private val ktorAuthDataSource: KtorAuthDataSource,
    private val settingsDataSource: SettingsAuthDataSource
): AuthRepository {

    override suspend fun login(login: String, password: String): AuthResponse {
        val token = ktorAuthDataSource.performLogin(KtorLoginRequest(login, password))
        settingsDataSource.saveToken(token.accessToken)
        return token
    }

    override fun isUserLoggedIn(): Boolean {
        return settingsDataSource.fetchToken().isNotBlank()
    }
}