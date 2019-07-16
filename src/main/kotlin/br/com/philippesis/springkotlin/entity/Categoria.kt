package br.com.philippesis.springkotlin.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class Categoria(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,

        @get: NotBlank
        val nome: String,

        @JsonManagedReference
        @OneToMany(mappedBy = "categoria", cascade = arrayOf(CascadeType.ALL), fetch = FetchType.EAGER)
        var livros: List<Livro> = emptyList()

)