package requesting_service.dto

data class UserDto(

    val id: Long,

    val username: String,

    val preferredContact: String,

    val email: String,

    val phone: String
)