package processing_service.service

import processing_service.dto.message.MessageDto
import reactor.core.publisher.Mono

interface ProcessingService {

    fun processImmediateMessage(messageDto: MessageDto): Mono<Void>
}