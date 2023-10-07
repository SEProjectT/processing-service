package processing_service

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@EnableScheduling
@SpringBootApplication
class RequestingServiceApplication

fun main(args: Array<String>) {
    runApplication<RequestingServiceApplication>(*args)
}