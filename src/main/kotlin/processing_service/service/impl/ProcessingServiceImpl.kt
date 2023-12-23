package processing_service.service.impl

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import processing_service.client.UserServiceClient
import processing_service.dto.PreferredContact
import processing_service.dto.message.MessageDto
import processing_service.service.MessageDistributor
import processing_service.service.ProcessingService

@Service
class ProcessingServiceImpl(
    private val userServiceClient: UserServiceClient,
    private val messageDistributors: Map<PreferredContact, MessageDistributor>
) : ProcessingService {

    private val logger = LoggerFactory.getLogger(ProcessingServiceImpl::class.java)

    override fun processImmediateMessage(messageDto: MessageDto) {
        logger.info("Starting processing message: {}", messageDto)

        userServiceClient.getUsers(messageDto.receiverIds)
            .flatMap {
                messageDistributors[it.preferredContact]!!
                    .distribute(it, messageDto)
            }
            .subscribe()
    }
}