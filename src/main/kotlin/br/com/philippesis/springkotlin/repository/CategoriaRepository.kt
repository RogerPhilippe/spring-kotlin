package br.com.philippesis.springkotlin.repository

import br.com.philippesis.springkotlin.entity.Categoria
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriaRepository: JpaRepository<Categoria, Long>