package processing_service.dto.message

import java.time.LocalDateTime

data class MessageDto(

    val receiverIds: List<Long>,

    val message: String,

    val scheduledAt: LocalDateTime?
)