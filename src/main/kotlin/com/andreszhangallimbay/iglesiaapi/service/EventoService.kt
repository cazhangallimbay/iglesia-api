package com.andreszhangallimbay.iglesiaapi.service
import com.andreszhangallimbay.iglesiaapi.model.Evento
import com.andreszhangallimbay.iglesiaapi.repository.EventoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

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
    try {
      if (evento.nombre.equals("")){
        throw Exception("nombre no puede estar vacio")
      }
      val response = eventoRepository.findById(evento.id)

        ?: throw Exception("El id ${evento.id} en dieta no existe")
      response.apply {
        this.nombre = evento.nombre
      }
      return eventoRepository.save(evento)
    }
    catch (ex: Exception) {
      throw ResponseStatusException(
        HttpStatus.NOT_FOUND, ex.message, ex)
    }
  }



  fun delete (id:Long): Boolean{
    eventoRepository.deleteById(id)
    return true
  }
}
