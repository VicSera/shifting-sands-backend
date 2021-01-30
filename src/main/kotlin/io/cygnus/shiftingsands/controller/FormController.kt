package io.cygnus.shiftingsands.controller

import io.cygnus.shiftingsands.exception.FormNotFound
import io.cygnus.shiftingsands.dto.FormDTO
import io.cygnus.shiftingsands.dto.ResponseDTO
import io.cygnus.shiftingsands.service.FormService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:4200"], allowCredentials = "true")
@RestController
@RequestMapping(path = ["/api"])
class FormController(
    @Autowired val formService: FormService
)
{
    @PostMapping(path = ["/new-form"])
    fun createForm(): ResponseEntity<FormDTO>
    {
        return ResponseEntity(formService.createForm(), HttpStatus.OK);
    }

    @PostMapping(path = ["/submit"])
    fun submitResponse(@RequestBody(required = true) responseDTO: ResponseDTO): ResponseEntity<Void>
    {
        return try {
            formService.submitResponse(responseDTO)
            ResponseEntity(HttpStatus.OK)
        } catch (formNotFound: FormNotFound) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping(path = ["/read/{readId}"])
    fun getNextResponse(@PathVariable("readId") readId: String): ResponseEntity<ResponseDTO>
    {
        try {
            formService.getNextResponse(readId)?.let {
                return ResponseEntity(it, HttpStatus.OK)
            } ?: return ResponseEntity(HttpStatus.EXPECTATION_FAILED)
        } catch (formNotFound: FormNotFound) {
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}
