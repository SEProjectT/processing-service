package processing_service.repository

import org.springframework.beans.factory.annotation.Autowired
import reactor.core.publisher.Mono
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux

@Component
class ScheduledMessageRepository {

//    @Autowired
//    private lateinit var template: R2dbcEntityTemplate

//    fun findById(id: Long): Mono<Users> {
//        return template.selectOne(query(where("id").`is`(id)),
//            Users::class.java)
//    }
//
//    fun findByIds(ids: List<Long>): Flux<Users> {
//        return template.select(query(where("id").`in`(ids)),
//            Users::class.java)
//    }
}