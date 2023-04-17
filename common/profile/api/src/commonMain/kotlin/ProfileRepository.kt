import models.Profile

interface ProfileRepository {
    suspend fun fetchProfileDetails(): Profile
    suspend fun login()
}