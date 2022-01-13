package com.andreszhangallimbay.iglesiaapi.controller

import com.andreszhangallimbay.iglesiaapi.model.Evento
import com.andreszhangallimbay.iglesiaapi.model.Usuario
import com.andreszhangallimbay.iglesiaapi.service.EventoService
import com.andreszhangallimbay.iglesiaapi.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/cedula")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class CedulaController {

    @Autowired
    lateinit var usuarioService: UsuarioService

    @GetMapping
    fun list(): List<Usuario> {
        return usuarioService.list()
    }
    @PostMapping
    fun save(@RequestBody usuario: Usuario): Usuario {
        return usuarioService.save(usuario)
    }

}
