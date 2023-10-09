package requesting_service.dto

import processing_service.dto.PreferredContact

data class UserDto(

    val id: Long,

    val username: String,

    val preferredContact: PreferredContact,

    val email: String,

    val phone: String
)