package repository

import model.Iglesia
import org.springframework.data.jpa.repository.JpaRepository

interface IglesiaRepository: JpaRepository<Iglesia, Long> {
fun findById (id: Long?): Iglesia?
}



