package  com.andreszhangallimbay.iglesiaapi.service
import com.andreszhangallimbay.iglesiaapi.model.Iglesia
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.andreszhangallimbay.iglesiaapi.repository.IglesiaRepository
import com.andreszhangallimbay.iglesiaapi.repository.MisaRepository
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@Service
class IglesiaService {

  @Autowired
  lateinit var iglesiaRepository: IglesiaRepository

  @Autowired
  lateinit var misaRepository: MisaRepository

  fun list(): List<Iglesia> {

    return iglesiaRepository.findAll()
  }


  fun save(iglesia: Iglesia): Iglesia {

    val response = misaRepository.findById(iglesia.id)

    return iglesiaRepository.save(iglesia)
  }


  fun update(iglesia: Iglesia): Iglesia {
if (iglesia.direccion.equals("")){
  throw Exception()
  }
    else {
  return iglesiaRepository.save(iglesia)

    }

  }

  fun updateDescription (iglesia: Iglesia): Iglesia {
    try {
      iglesia.nombre?.trim()?.isEmpty()
        ?: throw Exception("nombre no puede estar vacio")

      if (iglesia.nombre.equals("")){
      }
      val response = iglesiaRepository.findById(iglesia.id)
        ?: throw Exception("El id ${iglesia.id} en iglesia no existe")
      response.apply {
        this.nombre = iglesia.nombre
      }
      return iglesiaRepository.save(iglesia)
    }
    catch (ex: Exception) {
      throw ResponseStatusException(
        HttpStatus.NOT_FOUND, ex.message, ex)
    }
  }

  fun delete (id:Long): Boolean{
    iglesiaRepository.deleteById(id)
    return true
  }
}

