package com.andreszhangallimbay.iglesiaapi.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsService: UserDetailsService {
    @Autowired
    lateinit var usuarioService: UsuarioService

        override fun loadUserByUsername(username: String?): UserDetails {
            //Llamar usuarios de la base de datos
        val response = usuarioService.getUsuario(username)
            return User(response?.username,"{noop}"+response?.password, ArrayList())
        }
}