package com.andreszhangallimbay.iglesiaapi.repository

import com.andreszhangallimbay.iglesiaapi.model.Iglesia
import org.springframework.data.jpa.repository.JpaRepository

interface IglesiaRepository: JpaRepository<Iglesia, Long> {
fun findById (id: Long?): Iglesia?
}



