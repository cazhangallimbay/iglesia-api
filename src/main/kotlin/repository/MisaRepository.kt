import org.springframework.data.jpa.repository.JpaRepository


interface MisaRepository: JpaRepository<Misa, Long> {
  fun findById(id: Long?): Misa
}
