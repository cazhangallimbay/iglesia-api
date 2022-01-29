package com.andreszhangallimbay.iglesiaapi.service

import com.andreszhangallimbay.iglesiaapi.model.Iglesia
import com.andreszhangallimbay.iglesiaapi.model.Misa
import com.andreszhangallimbay.iglesiaapi.repository.IglesiaRepository
import com.andreszhangallimbay.iglesiaapi.repository.MisaRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class MisaServiceTest {
    @InjectMocks
    lateinit var misaService: MisaService

    @Mock
    lateinit var misaRepository: MisaRepository

    @Mock
    lateinit var iglesiaRepository: IglesiaRepository

    val jsonString = File("./src/test/resources/Misa/crearMisa.json").readText(Charsets.UTF_8)
    val misaMock = Gson().fromJson(jsonString, Misa::class.java)

    val jsonString = File("./src/test/resources/Iglesia/crearIglesia.json").readText(Charsets.UTF_8)
    val iglesiaMock = Gson().fromJson(jsonString, Iglesia::class.java)

    @Test
    fun createMisa(){
        //PAra actualizar
        /// LLAVES  FORENEAS
        Mockito.`when`(iglesiaRepository.findById(misaMock.iglesia_id)).thenReturn(iglesiaMock)
        Mockito.`when`(misaRepository.save(Mockito.any(Misa::class.java))).thenReturn(misaMock)
        val response = misaService.save(misaMock)
        Assertions.assertEquals(response.id, misaMock.id)

}

    @Test
    fun saveMisaIsFailed(){
        Assertions.assertThrows(Exception::class.java) {

            Mockito.`when`(misaRepository.save(Mockito.any(Misa::class.java))).thenReturn(misaMock)
            misaService.save(misaMock)
        }
    }

    @Test
    fun updateIsFailedWhen(){

        Assertions.assertThrows(Exception::class.java) {
            Mockito.`when`(iglesiaRepository.findById(misaMock.iglesia_id)).thenReturn(null)
            Mockito.`when`(misaRepository.save(Mockito.any(Misa::class.java))).thenReturn(misaMock)
            val response = misaService.save(misaMock)
            Assertions.assertEquals(response.id, misaMock.id)
        }
    }

    @Test
    fun updateDescrptionIsFailedWhen(){

        Assertions.assertThrows(Exception::class.java) {
            Mockito.`when`(iglesiaRepository.findById(misaMock.iglesia_id)).thenReturn(null)
            Mockito.`when`(misaRepository.save(Mockito.any(Misa::class.java))).thenReturn(misaMock)
            val response = misaService.update(misaMock)
            Assertions.assertEquals(response.id, misaMock.id)
        }

    }

    @Test
    fun delete(){

        Assertions.assertThrows(Exception::class.java) {
            Mockito.`when`(iglesiaRepository.findById(misaMock.iglesia_id)).thenReturn(misaMock)
            Mockito.`when`(misaRepository.save(Mockito.any(Misa::class.java))).thenReturn(misaMock)
            val response = misaService.delete(misaMock)
            Assertions.assertEquals(response, true)
        }
    }

}
