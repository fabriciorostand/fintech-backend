package br.com.fiap.fintech.exception;

import br.com.fiap.fintech.dto.exception.MethodArgumentNotValidResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionHandler {

        @org.springframework.web.bind.annotation.ExceptionHandler(EntityNotFoundException.class)
        public ResponseEntity<String> handleEntityNotFound() {
                return ResponseEntity
                        .notFound()
                        .build();
        }

        @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<List<MethodArgumentNotValidResponse>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
                List<FieldError> errors = ex.getFieldErrors();

                List<MethodArgumentNotValidResponse> response = errors.stream()
                        .map(MethodArgumentNotValidResponse::new)
                        .toList();

                return ResponseEntity
                        .badRequest()
                        .body(response);
        }

        @org.springframework.web.bind.annotation.ExceptionHandler(HttpMessageNotReadableException.class)
        public ResponseEntity<String> handleHttpMessageNotReadable() {
                return ResponseEntity
                        .badRequest()
                        .body("Corpo da requisição inválido ou malformado");
        }

        @org.springframework.web.bind.annotation.ExceptionHandler(BadCredentialsException.class)
        public ResponseEntity<String> handleBadCredentials() {
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body("Credenciais inválidas");
        }
}