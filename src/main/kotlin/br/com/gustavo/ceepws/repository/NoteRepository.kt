package br.com.gustavo.ceepws.repository

import br.com.gustavo.ceepws.model.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository: CrudRepository<Note, Long>