package br.com.fiap.fintech.exception;

import br.com.fiap.fintech.dto.exception.Error400Response;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> error404() {
        return ResponseEntity
                .notFound()
                .build();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Error400Response>> error400(MethodArgumentNotValidException ex) {
        List<FieldError> errors = ex.getFieldErrors();

        List<Error400Response> response = errors.stream()
                .map(Error400Response::new)
                .toList();

        return ResponseEntity
                .badRequest()
                .body(response);
    }
}