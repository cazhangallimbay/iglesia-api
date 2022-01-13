package com.andreszhangallimbay.iglesiaapi

import com.andreszhangallimbay.iglesiaapi.service.EventoService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class IglesiaApiApplicationTests {

	@Autowired
	lateinit var eventoService: EventoService

	@Test
	fun contextLoads() {
	}

	@Test
	fun verifySizeWordWhenIsIncorrect(){
		val response: Boolean = eventoService.verifyWord("")
		Assertions.assertEquals(false,response)
	}

	@Test
	fun verifySizeWordWhenIsCorrect(){
		val response: Boolean = eventoService.verifyWord("AAA")
		Assertions.assertEquals(true,response)
	}

}
