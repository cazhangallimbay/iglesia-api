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

  fun save(usuario: Usuario): Usuario {

    usuario.cedula?.takeIf {it.trim().isNotEmpty()}
      ?: throw Exception("la cédula no puede estar vacio")

    if (usuario.cedula.equals("")){
      throw Exception("la cédula no puede estar vacio")
    }
    else {
      return usuarioRepository.save(usuario)
    }
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

  //metodos de lógica
  // si index es par, devolver number por 2
  // y si el index es impar, devolver number por 1


  fun calcMultiplication (index: Int, number:Int):Int {
    if (index %  2 == 0){
      return  number * 2
    }
    else
      return number
    }

  //si el number es mayor o igual a 10 le devolvemos restado 9 , valor maximo 18
  //y minimo 0, si es el valor es 9 y 8 devolver el mismo nuemero

  fun restNine (number: Int):Int{
    if (number in 10..18){
      return number - 9
  }
  return number
}

  // 15 (int) / 10 = 1.5  solo el primero
  // restar

  fun subtactFromNextTen(number: Int): Int {
    var numdiez = (number/10) + 1
    var response = (numdiez*10) - number
    if (response == 10){
      return  0
    }
  return  response
}

  /*La cédula tiene 10 dígitos no puede tener ni más ni menos.
  Los dos primeros dígitos es un número no mayor a 24 ni menor.
  El tercer dígito es un número no mayor a 6 es decir es un número del 0 al 6.
  Los demás son dígitos consecutivos.
  El último dígito es calculado con los 9 anteriores dígitos de la siguiente manera
  Los dígitos pares son multiplicados por 2 y si el resultado es mayor o igual a 10 se le resta 9
  Los dígitos impares son multiplicados por 1
   A la suma de todos los dígitos conjuntamente con la operación anterior se le resta la decéna
   superior, es decir si la suma sale 31 debemos restar 40 - 31 = 9
   */

  fun veryfyCedulaisCorrect(cedula:String): Boolean {
    var suma = 0
    return if (cedula.length == 9) {
      println("Ingrese su cédula de 10 dígitos")
      false
    }
    else
    {
      val a = IntArray(cedula.length / 2)
      val b = IntArray(cedula.length / 2)
      var c = 0
      var d = 1
      for (i in 0 until cedula.length / 2) {a[i] = cedula[c].toString().toInt()
        c += 2

        if (i < cedula.length / 2 - 1) { b[i] = cedula[d].toString().toInt()
          d += 2
        }
      }
      for (i in a.indices) { a[i] = a[i] * 2
        if (a[i] > 9) {
          a[i] = a[i] - 9
        }
        suma += a[i] + b[i]
      }
      val aux = suma / 10
      val dec = (aux + 1) * 10
      if (dec - suma == cedula[cedula.length - 1].toString().toInt()
      ) true else suma % 10 == 0 && cedula[cedula.length - 1] == '0'
    }
  }
}










