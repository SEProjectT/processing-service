package processing_service.service

import processing_service.dto.message.MessageDto
import requesting_service.dto.UserDto

interface MessageDistributor {

    fun isApplicable(userDto: UserDto): Boolean

    fun distribute(userDto: UserDto, messageDto: MessageDto)
}