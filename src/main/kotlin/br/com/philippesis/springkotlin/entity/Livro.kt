package br.com.philippesis.springkotlin.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class Livro (

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @get: NotBlank
        val titulo: String,

        @get: NotBlank
        val autor: String,

        @JsonBackReference
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "categoria_id")
        val categoria: Categoria? = null

)