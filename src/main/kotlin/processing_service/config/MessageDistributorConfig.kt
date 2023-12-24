package processing_service.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import processing_service.dto.PreferredContact
import processing_service.service.MessageDistributor
import processing_service.service.impl.distributors.EmailMessageDistributor
import processing_service.service.impl.distributors.SmsMessageDistributor

@Configuration
class MessageDistributorConfig(
    private val emailDistributor: EmailMessageDistributor,
    private val smsDistributor: SmsMessageDistributor
) {

    @Bean
    fun messageDistributors(): Map<PreferredContact, MessageDistributor> {
        return mapOf(
            PreferredContact.EMAIL to emailDistributor,
            PreferredContact.SMS to smsDistributor
        )
    }
}