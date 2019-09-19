package br.com.gustavo.ceepws.service

import br.com.gustavo.ceepws.model.Note
import br.com.gustavo.ceepws.repository.NoteRepository
import org.springframework.stereotype.Service

@Service
class NoteService(
        private val noteRepository: NoteRepository
) {
    fun all(): List<Note>{
        return noteRepository.findAll().toList()
    }

    fun deleteById(id: Long){
        noteRepository.deleteById(id)
    }

    fun existsById(id: Long): Boolean {
        return noteRepository.existsById(id)
    }

    fun save(note: Note): Note {
        return noteRepository.save(note)
    }

    fun alter(id: Long, note: Note): Note {
        var safeNote = note.copy(id)
        return save(safeNote)
    }
}