package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dto.login.LoginRequest;
import br.com.fiap.fintech.dto.register.RegisterRequest;
import br.com.fiap.fintech.dto.user.UserResponse;
import br.com.fiap.fintech.model.User;
import br.com.fiap.fintech.security.TokenJWTResponse;
import br.com.fiap.fintech.security.TokenService;
import br.com.fiap.fintech.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    // Attributes
    private final UserService userService;
    private final AuthenticationManager manager;
    private final TokenService tokenService;

    // Methods

    // Responsável por cadastrar um usuário
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody @Valid RegisterRequest request, UriComponentsBuilder uriBuilder) {
        User user = userService.register(request);

        var uri = uriBuilder.path("/api/users/{id}").buildAndExpand(user.getId()).toUri();

        UserResponse response = new UserResponse(user);

        return ResponseEntity
                .created(uri)
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenJWTResponse> login(@RequestBody @Valid LoginRequest request) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());

        TokenJWTResponse response = new TokenJWTResponse(tokenJWT);

        return ResponseEntity.ok(response);
    }
}
