package br.com.philippesis.springkotlin.repository

import br.com.philippesis.springkotlin.entity.Livro
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LivroRepository: JpaRepository<Livro, Long>