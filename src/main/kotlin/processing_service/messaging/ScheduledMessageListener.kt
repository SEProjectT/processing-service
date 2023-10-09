package processing_service.messaging

import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import processing_service.dto.message.ScheduledMessageDto
import processing_service.service.RegisteringService

@Component
class ScheduledMessageListener(@Autowired private val registeringService: RegisteringService,
                               private val objectMapper: ObjectMapper) {

    private val logger = LoggerFactory.getLogger(ScheduledMessageListener::class.java)

    @KafkaListener(topics = ["\${topic.scheduled}"], groupId = "scheduled")
    fun listen(payload: ByteArray) {
        val scheduledMessageDto = objectMapper.readValue(payload, ScheduledMessageDto::class.java)

        logger.info("Scheduled message received: {}", scheduledMessageDto)

        registeringService.scheduleMessage(scheduledMessageDto)
    }
}