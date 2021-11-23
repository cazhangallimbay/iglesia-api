package com.andreszhangallimbay.iglesiaapi.repository
import com.andreszhangallimbay.iglesiaapi.model.Evento
import org.springframework.data.jpa.repository.JpaRepository

interface EventoRepository: JpaRepository<Evento, Long> {
fun findById (id: Long?): Evento
}



