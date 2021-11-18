import org.springframework.data.jpa.repository.JpaRepository

interface EventoRepository: JpaRepository<Evento, Long> {
fun findById (id: Long?): Evento
}



