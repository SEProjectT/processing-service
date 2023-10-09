package processing_service.messaging

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import processing_service.dto.message.MessageDto
import processing_service.service.ProcessingService

@Component
class ImmediateMessageListener(@Autowired private val processingService: ProcessingService,
                               private val objectMapper: ObjectMapper) {

    private val logger = LoggerFactory.getLogger(ImmediateMessageListener::class.java)

    @KafkaListener(topics = ["\${topic.immediate}"], groupId = "immediate")
    fun listen(payload: ByteArray) {
        val messageDto = objectMapper.readValue(payload, MessageDto::class.java)

        logger.info("Immediate message received: {}", messageDto)

        processingService.processImmediateMessage(messageDto)
    }
}