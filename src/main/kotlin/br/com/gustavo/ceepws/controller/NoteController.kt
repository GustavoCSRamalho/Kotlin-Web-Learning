package br.com.gustavo.ceepws.controller

import br.com.gustavo.ceepws.model.Note
import br.com.gustavo.ceepws.repository.NoteRepository
import br.com.gustavo.ceepws.service.NoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("notes")
class NoteController constructor (
    private val noteService: NoteService
) {

    // @Autowired
    // lateinit var noteRepository: NoteRepository

    @GetMapping
    fun list(): ResponseEntity<List<Note>> {
        return ResponseEntity.ok(noteService.all())
    }

    @PostMapping
    fun add(@RequestBody note: Note): ResponseEntity<Note>{
        val savedNote = noteService.save(note)
        return ResponseEntity.ok(savedNote)
    }

    @PutMapping("{id}")
    fun alter(@PathVariable id: Long, @RequestBody note: Note): ResponseEntity<Note> {
        if(noteService.existsById(id)){
            val alteredNote = noteService.alter(id, note)
            return ResponseEntity.ok(alteredNote)
        }
        return ResponseEntity.notFound().build()
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit>{
        if(noteService.existsById(id)){
            noteService.deleteById(id)
            return ResponseEntity.ok().build()
        }
        return ResponseEntity.notFound().build()
    }
}