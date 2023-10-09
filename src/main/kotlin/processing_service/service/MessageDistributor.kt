package processing_service.service

import processing_service.dto.message.MessageDto
import reactor.core.publisher.Mono
import requesting_service.dto.UserDto

interface MessageDistributor {

    fun distribute(userDto: UserDto, messageDto: MessageDto): Mono<Void>
}