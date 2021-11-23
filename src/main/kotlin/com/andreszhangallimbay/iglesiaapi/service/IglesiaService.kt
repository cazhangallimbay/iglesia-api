package  com.andreszhangallimbay.iglesiaapi.service
import com.andreszhangallimbay.iglesiaapi.model.Iglesia
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.andreszhangallimbay.iglesiaapi.repository.IglesiaRepository

@Service
class IglesiaService {
  @Autowired
  lateinit var iglesiaRepository: IglesiaRepository

  fun list(): List<Iglesia> {

    return iglesiaRepository.findAll()
  }


  fun save(iglesia: Iglesia): Iglesia {

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
    val response = iglesiaRepository.findById(iglesia.id)

      ?: throw Exception()

    response.apply {
      this.nombre = iglesia.nombre
    }
    return iglesiaRepository.save(response)
  }


  fun delete (id:Long): Boolean{
    iglesiaRepository.deleteById(id)
    return true
  }
}

