package br.com.philippesis.springkotlin.controller

import br.com.philippesis.springkotlin.entity.Livro
import br.com.philippesis.springkotlin.repository.CategoriaRepository
import br.com.philippesis.springkotlin.repository.LivroRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class LivroController(private val livroRepository: LivroRepository, private val categoriaRepository: CategoriaRepository) {

    @GetMapping("/livros")
    fun getAllLivros(): List<Livro> = livroRepository.findAll()

    @PostMapping("/livros")
    fun createNewLivro(@Valid @RequestBody livro: Livro) {
        livro.categoria?.let { categoriaRepository.save(it) }
        livroRepository.save(livro)
    }

    @GetMapping("/livros/{id}")
    fun getLivroById(@PathVariable(value = "id") livroId: Long) : ResponseEntity<Livro> {
        return livroRepository.findById(livroId).map { livro ->
            ResponseEntity.ok(livro)
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/livros/{id}")
    fun deleteLivrosById(@PathVariable(value = "id") livroId: Long): ResponseEntity<Void> {
        return livroRepository.findById(livroId).map { livro ->
            livroRepository.delete(livro)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }

}