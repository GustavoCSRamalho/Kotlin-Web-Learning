package br.com.gustavo.ceepws.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Note (@Id
            @GeneratedValue
            var id: Long,
            val title: String,
            val description: String)