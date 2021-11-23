package com.andreszhangallimbay.iglesiaapi.controller

import com.andreszhangallimbay.iglesiaapi.model.Evento
import com.andreszhangallimbay.iglesiaapi.service.EventoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/evento")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])
class EventoController {
    @Autowired
    lateinit var eventoService: EventoService

    @GetMapping
    fun list(): List<Evento>{
        return eventoService.list()
    }
  @PostMapping
  fun save(@RequestBody evento: Evento):Evento {
    return eventoService.save(evento)
  }


  @PutMapping
  fun update (@RequestBody evento: Evento):  Evento {
    return eventoService.update(evento)
  }

  @PatchMapping
  fun updateDescription (@RequestBody evento: Evento): Evento{
    return eventoService.updateDescription(evento)
  }

  @DeleteMapping("/delete/{id}")
  fun delete (@PathVariable("id") id: Long):Boolean{
    return eventoService.delete(id)
  }

}




