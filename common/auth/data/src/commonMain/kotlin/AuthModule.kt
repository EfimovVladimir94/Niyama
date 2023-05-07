import ktor.KtorAuthDataSource
import org.kodein.di.*
import settings.SettingsAuthDataSource

val authModule = DI.Module("authModule") {
    bind<KtorAuthDataSource>() with provider {
        KtorAuthDataSource(instance())
    }

    bind<AuthRepository>() with singleton {
        AuthRepositoryImpl(instance(), instance())
    }

    bind<SettingsAuthDataSource>() with provider {
        SettingsAuthDataSource(instance())
    }
}