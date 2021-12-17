package com.andreszhangallimbay.iglesiaapi.repository

import com.andreszhangallimbay.iglesiaapi.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UsuarioRepository: JpaRepository<Usuario, Long> {
    fun findById (id: Long?): Usuario?
    @Query(value = "SELECT * FROM USERS u WHERE u.username = :username",
                nativeQuery = true)
    fun findByUsername(username: String?): Usuario?
}



