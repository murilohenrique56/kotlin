package br.com.alura.forum.exceptions

import br.com.alura.forum.dto.ErrorView
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(
        e: NotFoundException,
        request: HttpServletRequest
    ): ErrorView {
        return ErrorView(
            statusCode = HttpStatus.NOT_FOUND.value(),
            error = HttpStatus.NOT_FOUND.name,
            message = e.message,
            path = request.servletPath
        )
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleServerError(
        e: Exception,
        request: HttpServletRequest
    ): ErrorView {
        return ErrorView(
            statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            error = HttpStatus.INTERNAL_SERVER_ERROR.name,
            message = e.message,
            path = request.servletPath
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleBadRequest(
        e: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ErrorView {
        val errorsMessage = HashMap<String, String?>()
        e.bindingResult.fieldErrors.forEach { errorsMessage.put(it.field, it.defaultMessage) }
        return ErrorView(
            statusCode = HttpStatus.BAD_REQUEST.value(),
            error = HttpStatus.BAD_REQUEST.name,
            message = errorsMessage.toString(),
            path = request.servletPath
        )
    }
}