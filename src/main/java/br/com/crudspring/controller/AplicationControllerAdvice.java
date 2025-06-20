package br.com.crudspring.controller;

import br.com.crudspring.exception.RecordNotFoundException;
import br.com.crudspring.exception.ResourceAlredyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class AplicationControllerAdvice {

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFoundException(RecordNotFoundException e) {
        // Log the exception or handle it as needed
        return e.getMessage();
    }




//    private ErrorResponse gerarError(HttpServletRequest request, HttpStatus status, String message) {
//       return ErrorResponse.builder()
//               .timestamp(LocalDate.now().toString())
//               .status(status.value())
//               .message(message)
//               .path(request.getRequestURI())
//               .build();
//    }
}
