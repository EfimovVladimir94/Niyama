import ktor.KtorAuthDataSource
import org.kodein.di.*

val authModule = DI.Module("authModule") {
    bind<KtorAuthDataSource>() with provider {
        KtorAuthDataSource(instance())
    }

    bind<AuthRepository>() with singleton {
        AuthRepositoryImpl(instance())
    }
}