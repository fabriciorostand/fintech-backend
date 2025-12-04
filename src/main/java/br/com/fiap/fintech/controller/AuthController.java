package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dto.login.LoginRequest;
import br.com.fiap.fintech.dto.login.LoginResponse;
import br.com.fiap.fintech.dto.register.RegisterRequest;
import br.com.fiap.fintech.dto.user.UserResponse;
import br.com.fiap.fintech.model.User;
import br.com.fiap.fintech.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    // Attributes
    private final UserService userService;

    // Methods

    // Responsável por cadastrar um usuário
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody @Valid RegisterRequest request) {
        User user = userService.register(request);

        UserResponse response = new UserResponse(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // Responsável por logar um usuário
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest loginRequest) {
        try {
            User user = userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());


            LoginResponse response = new LoginResponse(
                    true,
                    "Login realizado com sucesso!",
                    user.getId(),
                    user.getName()
            );

            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            LoginResponse response = new LoginResponse(
                    false,
                    e.getMessage(),
                    null,
                    null
            );

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(response);
        }
    }

}
