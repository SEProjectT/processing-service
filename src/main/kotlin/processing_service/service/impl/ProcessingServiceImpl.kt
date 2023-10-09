package processing_service.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import processing_service.client.UserServiceClient
import processing_service.dto.message.MessageDto
import processing_service.service.MessageDistributor
import processing_service.service.ProcessingService
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import requesting_service.dto.UserDto

@Service
class ProcessingServiceImpl(@Autowired private val userServiceClient: UserServiceClient,
    val messageDistributors: List<MessageDistributor>) : ProcessingService {

    private val logger = org.slf4j.LoggerFactory.getLogger(ProcessingServiceImpl::class.java)

    override fun processImmediateMessage(messageDto: MessageDto): Mono<Void> {
        logger.info("Starting processImmediateMessage")

        userServiceClient.getUsers(messageDto.receiverIds)// TODO: почему-то не обращается к дистрибьюторам, но правильно достает все из юзер сервиса
            .flatMap<UserDto> { userDto ->
                Flux.fromIterable(messageDistributors)
                    .flatMap { distributor ->
                        Mono.fromRunnable { distributor.distribute(userDto, messageDto) }
                    }
            }
            .subscribe()


        return Mono.empty()
    }
}
