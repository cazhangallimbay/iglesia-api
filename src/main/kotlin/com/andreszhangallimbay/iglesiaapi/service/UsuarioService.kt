package com.andreszhangallimbay.iglesiaapi.service

import com.andreszhangallimbay.iglesiaapi.model.Usuario
import com.andreszhangallimbay.iglesiaapi.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class UsuarioService {
  @Autowired
  lateinit var usuarioRepository: UsuarioRepository


  fun list(): List<Usuario> {

    return usuarioRepository.findAll()
  }


  fun getUsuario(usernane: String?): Usuario?{
    try {
      val response = usuarioRepository.findByUsername(usernane)
        ?: throw Exception("usuario no existe")
      return response
    } catch (ex: Exception){
      throw ResponseStatusException(
        HttpStatus.NOT_FOUND, ex.message, ex)
    }
  }

  fun update(usuario: Usuario): Usuario{

    return usuarioRepository.save(usuario)

  }
}



