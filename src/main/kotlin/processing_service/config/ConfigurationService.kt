package processing_service.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class ConfigurationService {

    @Bean
    fun webClient(): WebClient = WebClient.create()
}