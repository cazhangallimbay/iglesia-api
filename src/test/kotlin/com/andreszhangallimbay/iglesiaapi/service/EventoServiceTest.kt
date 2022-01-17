package com.andreszhangallimbay.iglesiaapi.service

import com.andreszhangallimbay.iglesiaapi.model.Evento
import com.andreszhangallimbay.iglesiaapi.repository.EventoRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class EventoServiceTest {

    @InjectMocks
    lateinit var eventoService: EventoService

    @Mock
    lateinit var eventoRepository: EventoRepository

    val returnObject: Evento = Evento().apply {
        id=1
        nombre= "Bautizo"
        fecha = Date(11/1/2021)
        hora = Date(11/1/2021)
    }

   val newObject: Evento = Evento().apply {
        id= 1
        nombre= "Bautizo"
       fecha = Date(11/1/2021)
       hora = Date(11/1/2021)}

    @Test
    fun saveIsCorrect(){

        Mockito.`when`(eventoRepository.save(Mockito.any(Evento::class.java))).thenReturn(returnObject)
        val response = eventoService.save(newObject)
        Assertions.assertEquals(response.id, newObject.id)
        Assertions.assertEquals(response.nombre, newObject.nombre)
    }
}