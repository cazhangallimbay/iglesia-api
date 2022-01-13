package com.andreszhangallimbay.iglesiaapi.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest {

    //inyectar las clases a probar

    @Autowired
    lateinit var userService: UsuarioService

    @Test
    fun calcMultiplicationIfIsPair(){
        val response = userService.calcMultiplication(2,4)
            Assertions.assertEquals(8,response)
    }
    @Test
    fun calcMultiplicationIfIsNotPair(){
        val response = userService.calcMultiplication(1,4)
        Assertions.assertEquals(4,response)
    }

    @Test
    fun restNineIfIsLessTen(){

        val response = userService.restNine(9)
        Assertions.assertEquals(9,response)
    }

    @Test
    fun restNineIfIsHigherTen(){

        val response = userService.restNine(12)
        Assertions.assertEquals(3,response)
    }

    @Test
    fun subtactFromNextTen(){
        val response = userService.subtactFromNextTen(15)
       Assertions.assertEquals(5,response)
    }

    @Test
    fun veryfyCedulaisCorrect() {
        val response = userService.veryfyCedulaisCorrect("0105496624")
        Assertions.assertEquals(true,response)
    }

    @Test
    fun veryfyCedulaisNotCorrect() {
        val response = userService.veryfyCedulaisCorrect("0000099739")
        Assertions.assertEquals(false, response)
    }

}