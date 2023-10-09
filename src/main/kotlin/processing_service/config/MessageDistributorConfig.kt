package processing_service.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import processing_service.dto.PreferredContact
import processing_service.service.MessageDistributor
import processing_service.service.impl.distributors.EmailMessageDistributor

@Configuration
class MessageDistributorConfig(@Autowired val emailDistributor: EmailMessageDistributor,
    val smsDistributor: EmailMessageDistributor, val telegramDistributor: EmailMessageDistributor) {

    @Bean
    fun messageDistributors(): Map<PreferredContact, MessageDistributor> {
        return mapOf(
            PreferredContact.EMAIL to emailDistributor,
            PreferredContact.SMS to smsDistributor,
            PreferredContact.TELEGRAM to telegramDistributor
        )
    }
}