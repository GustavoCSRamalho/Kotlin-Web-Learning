package br.com.gustavo.ceepws.controller

import br.com.gustavo.ceepws.model.Note
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("notes")
class NoteController {

    @GetMapping
    fun list(): List<Note> {
        return listOf(Note("Leitura","Livro de Spring Boot"),
                Note("Pesquisa","Ambiente com Docker"))
    }
}