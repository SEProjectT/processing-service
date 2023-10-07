package processing_service.messaging

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import processing_service.dto.ScheduledMessageDto
import processing_service.service.RegisteringService
import reactor.core.publisher.Mono

@Component
class ScheduledMessageListener(@Autowired val registeringService: RegisteringService) {

    private val logger = LoggerFactory.getLogger(ScheduledMessageListener::class.java)

    @KafkaListener(topics = ["\${topic.scheduled}"], groupId = "scheduled")
    fun listen(scheduledMessageDto: ScheduledMessageDto) {
        logger.info("Received scheduled message: $scheduledMessageDto")

//        return registeringService.scheduleMessage(scheduledMessageDto)
    }
}