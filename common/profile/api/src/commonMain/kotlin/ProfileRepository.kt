import models.Profile

interface ProfileRepository {
    suspend fun fetchProfileDetails(): Profile
}