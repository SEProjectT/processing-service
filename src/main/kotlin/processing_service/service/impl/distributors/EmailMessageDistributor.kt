package processing_service.service.impl.distributors

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import processing_service.dto.message.EmailMessageDto
import processing_service.dto.message.MessageDto
import processing_service.service.KafkaProducer
import processing_service.service.MessageDistributor
import reactor.core.publisher.Mono
import requesting_service.dto.UserDto

@Component
class EmailMessageDistributor(@Autowired val kafkaProducer: KafkaProducer) : MessageDistributor {

    @Value("\${topic.email}")
    private lateinit var emailTopic: String

    override fun distribute(userDto: UserDto, messageDto: MessageDto): Mono<Void> {
        return kafkaProducer.produce(emailTopic, EmailMessageDto(userDto.email, messageDto.message))
    }
}