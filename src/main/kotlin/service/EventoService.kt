import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class EventoService {
  @Autowired
  lateinit var eventoRepository: EventoRepository


  fun list(): List<Evento> {

    return eventoRepository.findAll()
  }


  fun save(evento: Evento): Evento{
    if (evento.nombre.equals("")){
      throw Exception()
    }
    else {
    return eventoRepository.save(evento)
  }

  }



  fun update(evento: Evento): Evento{

    return eventoRepository.save(evento)

  }

  fun updateDescription (evento: Evento):Evento{
    val response = eventoRepository.findById(evento.id)

      ?: throw Exception()

    response.apply {
      this.nombre = evento.nombre
    }
    return eventoRepository.save(response)
  }

  fun delete (id:Long): Boolean{
    eventoRepository.deleteById(id)
    return true
  }
}

