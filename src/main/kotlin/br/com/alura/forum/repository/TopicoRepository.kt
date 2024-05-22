package br.com.alura.forum.repository

import br.com.alura.forum.dto.TopicoPorCategoriaDto
import br.com.alura.forum.model.Topico
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicoRepository: JpaRepository<Topico, Long> {

    fun findByCursoNome(nomeCurso: String, paginacao: Pageable): Page<Topico>

    @Query(value = "SELECT NEW br.com.alura.forum.dto.TopicoPorCategoriaDto(c.categoria, count(t)) FROM Topico t JOIN t.curso c group by c.categoria")
    fun relatorio(): List<TopicoPorCategoriaDto>
}