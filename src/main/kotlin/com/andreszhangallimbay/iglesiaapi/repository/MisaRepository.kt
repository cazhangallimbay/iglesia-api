package com.andreszhangallimbay.iglesiaapi.repository
import com.andreszhangallimbay.iglesiaapi.model.Misa
import org.springframework.data.jpa.repository.JpaRepository


interface MisaRepository: JpaRepository<Misa, Long> {
  fun findById(id: Long?): Misa
}
