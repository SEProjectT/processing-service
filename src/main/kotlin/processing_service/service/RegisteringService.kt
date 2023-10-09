package processing_service.service

import processing_service.dto.message.MessageDto

interface RegisteringService {

    fun scheduleMessage(scheduledMessageDto: MessageDto)
}