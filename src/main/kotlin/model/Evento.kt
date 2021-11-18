import java.util.*
import javax.persistence.*

@Entity
@Table(name = "evento")
class Evento {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(updatable = false)
  var id: Long? = null
  var nombre: String? = null
  var fecha: Date? = null
  var hora: Date? = null
}
