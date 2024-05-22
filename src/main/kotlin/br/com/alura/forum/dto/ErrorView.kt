package br.com.alura.forum.dto

import java.time.LocalDateTime

data class ErrorView (
    val message: String?,
    val error: String,
    val statusCode: Int,
    val path: String,
    val timeStamp: LocalDateTime = LocalDateTime.now()
)