import ktor.KtorProfileDataSource
import org.kodein.di.*

val profileModule = DI.Module("profileModule") {

    bind<KtorProfileDataSource>() with provider {
        KtorProfileDataSource(instance())
    }

    bind<ProfileRepository>() with singleton {
        ProfileRepositoryImpl(instance())
    }
}