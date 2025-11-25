package br.com.fiap.fintech.dto;

import br.com.fiap.fintech.model.User;
import lombok.Getter;

@Getter
public class UserResponse {
    private int id;
    private String name;
    private String email;

    // Construtor que converte User para UserResponse
    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}