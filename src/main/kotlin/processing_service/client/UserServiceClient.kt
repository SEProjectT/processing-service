package processing_service.client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import processing_service.util.exception.UserNotFoundException
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import requesting_service.dto.UserDto

@Service
class UserServiceClient(@Autowired val webClient: WebClient) {

    fun getUsers(ids: List<Long>): Flux<UserDto> {
        return webClient.get()
            .uri("/users?ids=${ids.joinToString(",")}")
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