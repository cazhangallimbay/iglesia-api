package com.andreszhangallimbay.iglesiaapi.controller
import com.andreszhangallimbay.iglesiaapi.model.Misa
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import com.andreszhangallimbay.iglesiaapi.service.MisaService

@RestController
@RequestMapping("/misa")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])
class MisaController {
    @Autowired
    lateinit var misaService: MisaService

    @GetMapping
    fun list(): List<Misa>{
        return misaService.list()
    }
  @PostMapping
  fun save(@RequestBody misa: Misa): Misa{
    return misaService.save(misa)
  }


  @PutMapping
  fun update (@RequestBody misa: Misa):  Misa {
    return misaService.update(misa)
  }

  @PatchMapping
  fun updateDescription (@RequestBody misa: Misa): Misa {
    return misaService.updateDescription(misa)
  }

  @DeleteMapping("/delete/{id}")
  fun delete (@PathVariable("id") id: Long):Boolean{
    return misaService.delete(id)
  }

}




