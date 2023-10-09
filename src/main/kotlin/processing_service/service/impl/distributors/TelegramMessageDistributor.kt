package processing_service.service.impl.distributors

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import processing_service.dto.PreferredContact
import processing_service.dto.message.MessageDto
import processing_service.dto.message.TelegramMessageDto
import processing_service.service.KafkaProducer
import processing_service.service.MessageDistributor
import requesting_service.dto.UserDto

@Component
class TelegramMessageDistributor(@Autowired val kafkaProducer: KafkaProducer) : MessageDistributor {

    override fun isApplicable(userDto: UserDto): Boolean {
        return userDto.preferredContact == PreferredContact.TELEGRAM
    }

    override fun distribute(userDto: UserDto, messageDto: MessageDto) {
        if (isApplicable(userDto)) {
            kafkaProducer.produce("\${topic.telegram}", TelegramMessageDto(userDto.phone, messageDto.message))
        }
    }
}