package processing_service.util

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import processing_service.util.exception.UserNotFoundException

@ControllerAdvice
class GlobalExceptionHandler {

    private val logger = LoggerFactory.getLogger(GlobalExceptionHandler::class.java)

    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(e: UserNotFoundException): ResponseEntity<Any?> {
        logger.error("Exception caused: {}. Stacktrace: {}", e.message, e)
        return ResponseEntity.notFound().build()
    }
}