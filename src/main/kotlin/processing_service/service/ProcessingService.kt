package processing_service.service

import processing_service.dto.message.MessageDto

interface ProcessingService {

    fun processImmediateMessage(messageDto: MessageDto)
}