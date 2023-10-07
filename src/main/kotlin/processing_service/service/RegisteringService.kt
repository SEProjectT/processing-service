package processing_service.service

import processing_service.dto.ScheduledMessageDto
import reactor.core.publisher.Mono

interface RegisteringService {

    fun scheduleMessage(scheduledMessageDto: ScheduledMessageDto): Mono<Void>
}