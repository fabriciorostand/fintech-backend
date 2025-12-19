package br.com.fiap.fintech.dto.exception;

import lombok.Getter;
import org.springframework.validation.FieldError;

@Getter
public class MethodArgumentNotValidResponse {
    private final String field;
    private final String message;

    // Construtor que converte FieldError para Error400Response
    public MethodArgumentNotValidResponse(FieldError error) {
        this.field = error.getField();
        this.message = error.getDefaultMessage();
    }
}