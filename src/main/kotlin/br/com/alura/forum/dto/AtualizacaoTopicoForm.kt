package br.com.alura.forum.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class AtualizacaoTopicoForm (
    @field:NotNull val id: Long,
    @field:NotEmpty var titulo: String,
    @field:NotEmpty var mensagem: String
)
