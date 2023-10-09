package processing_service.service.impl

import org.springframework.stereotype.Service
import processing_service.dto.message.MessageDto
import processing_service.service.RegisteringService

@Service
class RegisteringServiceImpl : RegisteringService {
    override fun scheduleMessage(scheduledMessageDto: MessageDto) {
        TODO("Not yet implemented")
    }
}