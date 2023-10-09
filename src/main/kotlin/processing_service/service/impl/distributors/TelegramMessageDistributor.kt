package processing_service.service.impl.distributors

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import processing_service.dto.message.MessageDto
import processing_service.dto.message.PhoneMessageDto
import processing_service.service.KafkaProducer
import processing_service.service.MessageDistributor
import reactor.core.publisher.Mono
import requesting_service.dto.UserDto

@Component
class TelegramMessageDistributor(@Autowired val kafkaProducer: KafkaProducer) : MessageDistributor {

    @Value("\${topic.telegram}")
    private lateinit var telegramTopic: String

    override fun distribute(userDto: UserDto, messageDto: MessageDto): Mono<Void> {
        return kafkaProducer.produce(telegramTopic, PhoneMessageDto(userDto.phone, messageDto.message))
    }
}