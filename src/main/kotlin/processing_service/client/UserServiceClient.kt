package processing_service.client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import processing_service.util.exception.UserNotFoundException
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import requesting_service.dto.UserDto

@Service
class UserServiceClient(@Autowired private val webClient: WebClient) {

    @Value("\${user-service.get-users-uri}")
    private lateinit var uri: String

    fun getUsers(ids: List<Long>): Flux<UserDto> {
        return webClient.get()
            .uri("${uri}?ids=${ids.joinToString(",")}")
            .retrieve()
            .bodyToFlux(UserDto::class.java)
            .collectList()
            .flatMapMany { users ->
                Flux.fromIterable(users).flatMap { user ->
                    if (user.id in ids) {
                        Mono.just(user)
                    } else {
                        Mono.error(UserNotFoundException("User with id ${user.id} not found"))
                    }
                }
            }
    }
}