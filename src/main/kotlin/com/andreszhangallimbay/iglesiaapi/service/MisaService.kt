package com.andreszhangallimbay.iglesiaapi.service

import com.andreszhangallimbay.iglesiaapi.model.Misa
import com.andreszhangallimbay.iglesiaapi.repository.MisaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

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


    fun updateDescription(misa: Misa): Misa {
        try {
            if (misa.hora?.equals(false) == true){
                throw Exception("nombre no puede estar vacio")
            }
            val response = misaRepository.findById(misa.id)
            response.apply {
                this.fecha = misa.fecha
            }
            return misaRepository.save(misa)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
    }
}


  fun delete (id:Long): Boolean{
    misaRepository.deleteById(id)
    return true
  }
}




