package com.andreszhangallimbay.iglesiaapi.service
import com.andreszhangallimbay.iglesiaapi.model.Iglesia
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
class IglesiaServiceTest {
    @InjectMocks
    lateinit var iglesiaService: IglesiaService

    @Mock
    lateinit var iglesiaRepository: IglesiaRepository

    @Mock
    lateinit var misaRepository: MisaRepository

    val jsonString = File("./src/test/resources/Iglesia/crearIglesia.json").readText(Charsets.UTF_8)
    val iglesiaMock = Gson().fromJson(jsonString, Iglesia::class.java)

    @Test
    fun createIglesia(){
        //Para actualizar
        //LAVES FORANEAS

        //Mockito.`when`(misaRepository.findById(iglesiaMock.misa_id)).thenReturn(misaMock)
        Mockito.`when`(iglesiaRepository.save(Mockito.any(Iglesia::class.java))).thenReturn(iglesiaMock)
        val response = iglesiaService.save(iglesiaMock)
        Assertions.assertEquals(response.id, iglesiaMock.id)
        Assertions.assertEquals(response.nombre, iglesiaMock.nombre)
        Assertions.assertEquals(response.color, iglesiaMock.color)
        Assertions.assertEquals(response.direccion, iglesiaMock.direccion)
    }

    @Test
    fun createIglesiaFailedWhenNameIsEmpty(){
        Assertions.assertThrows(Exception::class.java) {
            //modificando el objeto
            iglesiaMock.apply { nombre = "123" }
            Mockito.`when`(iglesiaRepository.save(Mockito.any(Iglesia::class.java))).thenReturn(iglesiaMock)
            iglesiaService.save(iglesiaMock)
        }
    }

}