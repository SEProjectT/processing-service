package processing_service.service

import processing_service.dto.MessageDto

interface ProcessingService {

    fun processImmediateMessage(messageDto: MessageDto)
}