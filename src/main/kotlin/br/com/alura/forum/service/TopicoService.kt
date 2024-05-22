package br.com.alura.forum.service

import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoPorCategoriaDto
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.exceptions.NotFoundException
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Topico
import br.com.alura.forum.repository.TopicoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper
) {
    private val notFoundMessage: String = "Não foi encontrado"

    fun listar(
        nomeCurso: String?,
        paginacao: Pageable
    ): Page<TopicoView> {
        val topicos = if(nomeCurso == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByCursoNome(nomeCurso, paginacao)
        }
        return topicos.map { t: Topico -> topicoViewMapper.map(t) }
    }

    fun buscarPorId(id: Long): TopicoView {
        return repository.findById(id).map { t -> topicoViewMapper.map(t) }.orElseThrow { NotFoundException(notFoundMessage) }
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico =  repository.findById(form.id).orElseThrow { NotFoundException(notFoundMessage) }
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
       repository.deleteById(id)
    }

    fun relatorio(): List<TopicoPorCategoriaDto> {
      return  repository.relatorio()
    }

}