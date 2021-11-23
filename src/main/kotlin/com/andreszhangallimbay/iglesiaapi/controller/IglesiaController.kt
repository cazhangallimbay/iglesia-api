package com.andreszhangallimbay.iglesiaapi.controller
import com.andreszhangallimbay.iglesiaapi.model.Iglesia
import com.andreszhangallimbay.iglesiaapi.service.IglesiaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/iglesia")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])
class IglesiaController {
  @Autowired
  lateinit var iglesiaService: IglesiaService

  @GetMapping
  fun list(): List<Iglesia>{
    return iglesiaService.list()
  }
  @PostMapping
 fun save (@RequestBody iglesia: Iglesia): Iglesia {
   return iglesiaService.save(iglesia)

 }

  @PutMapping
  fun update (@RequestBody iglesia: Iglesia): Iglesia {
    return iglesiaService.update(iglesia)
    
}

  @PatchMapping
  fun updateDescription (@RequestBody iglesia: Iglesia): Iglesia {
    return iglesiaService.updateDescription(iglesia)
  }

  @DeleteMapping("/delete/{id}")
  fun delete (@PathVariable("id") id: Long):Boolean{
    return iglesiaService.delete(id)
  }

}

