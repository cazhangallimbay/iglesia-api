package service

import Misa
import MisaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MisaService {
        @Autowired
        lateinit var misaRepository: MisaRepository


        fun list(): List<Misa> {
            return misaRepository.findAll()
        }
  fun save(misa: Misa): Misa {

    return misaRepository.save(misa)
  }



  fun update(misa: Misa): Misa {

    return misaRepository.save(misa)

  }



  fun updateDescription (misa: Misa): Misa {
    val response = misaRepository.findById(misa.id)

      ?: throw Exception()

    response.apply {
      this.fecha=misa.fecha
    }
    return misaRepository.save(response)
  }

  fun delete (id:Long): Boolean{
    misaRepository.deleteById(id)
    return true
  }
}




