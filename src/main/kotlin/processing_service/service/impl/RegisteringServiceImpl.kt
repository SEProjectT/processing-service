package processing_service.service.impl

import org.springframework.stereotype.Service
import processing_service.dto.message.ScheduledMessageDto
import processing_service.service.RegisteringService
import reactor.core.publisher.Mono

@Service
class RegisteringServiceImpl : RegisteringService {
    override fun scheduleMessage(scheduledMessageDto: ScheduledMessageDto): Mono<Void> {
        TODO("Not yet implemented")
    }
}