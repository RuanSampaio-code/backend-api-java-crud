package br.com.crudspring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.NotActiveException;
import java.time.LocalDateTime;

//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//
////    @ExceptionHandler(MethodArgumentNotValidException.class)
////    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) {
////
////        String message = ex.getBindingResult()
////                .getFieldErrors()
////                .stream()
////                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
////                .collect(Collectors.joining(", "));
////
////        ErrorResponse errorResponse = gerarError(request, HttpStatus.BAD_REQUEST, message);
////        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
////    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorResponse> handleException(Exception ex, HttpServletRequest request) {
//        ErrorResponse errorResponse = gerarError(request, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
//    }
//
//    @ExceptionHandler(ResourceAlredyExistsException.class)
//    public ResponseEntity<ErrorResponse> handleResourceAlreadyExistsException(ResourceAlredyExistsException ex, HttpServletRequest request) {
//        ErrorResponse errorResponse = gerarError(request, HttpStatus.CONFLICT, ex.getMessage());
//        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
//    }
//
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex, HttpServletRequest request) {
//        ErrorResponse errorResponse = gerarError(request, HttpStatus.NOT_FOUND, ex.getMessage());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//    }
//
//
//    private ErrorResponse gerarError(HttpServletRequest request, HttpStatus status, String message) {
//       return ErrorResponse.builder()
//               .timestamp(LocalDate.now().toString())
//               .status(status.value())
//               .message(message)
//               .path(request.getRequestURI())
//               .build();
//    }
//}
