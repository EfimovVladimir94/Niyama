import ktor.KtorProfileDataSource
import models.Profile

class ProfileRepositoryImpl(private val ktorProfileDataSource: KtorProfileDataSource): ProfileRepository {
    override suspend fun fetchProfileDetails(): Profile {
        return ktorProfileDataSource.fetchProfileDetails()
    }
}