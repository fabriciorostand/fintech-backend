package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dto.*;
import br.com.fiap.fintech.model.User;
import br.com.fiap.fintech.service.BankAccountService;
import br.com.fiap.fintech.service.TransactionService;
import br.com.fiap.fintech.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    // Attributes
    private final UserService userService;
    private final TransactionService transactionService;
    private final BankAccountService bankAccountService;

    // Methods

    // Responsável por criar um usuário no DB
    @PostMapping
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request) {
        User user = userService.register(request);

        UserResponse response = new UserResponse(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // Responsável por consultar um usuário por id no DB
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable int id) {
        User found = userService.findById(id);

        UserResponse response = new UserResponse(found);

        return ResponseEntity.ok(response);
    }

    // Responsável por consultar todos usuários no DB
    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        List<User> found = userService.findAll();

        List<UserResponse> response = found.stream()
                .map(UserResponse::new)
                .toList();

        return ResponseEntity.ok(response);
    }

    // Responsável por consultar todas as transações de um usuário
    @GetMapping("/{id}/transactions")
    public ResponseEntity<List<TransactionResponse>> findByUserId(@PathVariable int id) {
        // Valida se o usuário existe
        userService.findById(id);

        List<TransactionResponse> response = transactionService.findByUserId(id).stream()
                .map(TransactionResponse::new)
                .toList();

        // Busca as transações através do service apropriado
        return ResponseEntity.ok(response);
    }

    // Responsável por consultar todas as contas bancárias de um usuário
    @GetMapping("/{id}/bank-accounts")
    public ResponseEntity<List<BankAccountResponse>> findBankAccountsByUserId(@PathVariable int id) {
        // Valida se o usuário existe
        userService.findById(id);

        List<BankAccountResponse> response = bankAccountService.findByUserId(id).stream()
                .map(BankAccountResponse::new)
                .toList();

        // Busca as contas bancárias através do service apropriado
        return ResponseEntity.ok(response);
    }

    // Responsável por consultar todas as transações de determinado tipo de um usuário
    @GetMapping("/{id}/transactions/transaction-types/{transactionTypeId}")
    public ResponseEntity<List<TransactionResponse>> findByUserIdAndTransactionTypeId(@PathVariable int id, @PathVariable int transactionTypeId) {
        List<TransactionResponse> response = transactionService.findByUserIdAndTransactionTypeId(id, transactionTypeId).stream()
                .map(TransactionResponse::new)
                .toList();

        return ResponseEntity.ok(response);
    }

    // Responsável por atualizar um usuário no DB
    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable int id, @RequestBody User user) {
        User updated = userService.update(id, user);

        UserResponse response = new UserResponse(updated);

        return ResponseEntity.ok(response);
    }

    // Responsável por excluir um usuário no DB
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        userService.delete(id);

        return ResponseEntity.noContent().build();
    }

    // Responsável por autenticar um usuário
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
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