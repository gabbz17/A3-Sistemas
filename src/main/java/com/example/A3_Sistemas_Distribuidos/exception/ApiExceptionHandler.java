package com.example.A3_Sistemas_Distribuidos.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> methodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest st, BindingResult rs){
        log.error("Api error - ", ex);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(st, HttpStatus.UNPROCESSABLE_ENTITY,"Campo(s) inválido(s)!", rs));
    }

    @ExceptionHandler(NameUniqueException.class)
    public ResponseEntity<ErrorMessage> uniqueViolationException(RuntimeException ex, HttpServletRequest st){
        log.error("Api error - ", ex);
        return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(st, HttpStatus.CONFLICT,ex.getMessage()));
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorMessage> entityIdNotFoundException(RuntimeException ex, HttpServletRequest st){
        log.error("Api error - ", ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(st, HttpStatus.NOT_FOUND,ex.getMessage()));
    }

    @ExceptionHandler(RoleException.class)
    public ResponseEntity<ErrorMessage> roleException(RuntimeException ex, HttpServletRequest st){
        log.error("Api error - ", ex);
        return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(st, HttpStatus.CONFLICT,ex.getMessage()));
    }

    @ExceptionHandler(NameNotFoundException.class)
    public ResponseEntity<ErrorMessage> entityNameNotFoundException(RuntimeException ex, HttpServletRequest st){
        log.error("Api error - ", ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(st, HttpStatus.NOT_FOUND,ex.getMessage()));
    }

    @ExceptionHandler(ListNotFoundException.class)
    public ResponseEntity<ErrorMessage> listNotFoundException(ListNotFoundException ex, HttpServletRequest st) {
        log.error("Api error - ", ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorMessage(st, HttpStatus.NOT_FOUND,ex.getMessage()));
    }
}
