package br.com.fiap.fintech.controller;

import br.com.fiap.fintech.dto.LoginRequest;
import br.com.fiap.fintech.dto.LoginResponse;
import br.com.fiap.fintech.model.BankAccount;
import br.com.fiap.fintech.model.Transaction;
import br.com.fiap.fintech.model.User;
import br.com.fiap.fintech.service.BankAccountService;
import br.com.fiap.fintech.service.TransactionService;
import br.com.fiap.fintech.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    // Attributes
    private final UserService userService;
    private final TransactionService transactionService;
    private final BankAccountService bankAccountService;

    // Constructors
    public UserController(UserService userService, TransactionService transactionService, BankAccountService bankAccountService) {
        this.userService = userService;
        this.transactionService = transactionService;
        this.bankAccountService = bankAccountService;
    }

    // Methods

    // Responsável por criar um usuário no DB
    @PostMapping
    public ResponseEntity<User> register(@RequestBody User user) {
        User registered = userService.register(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registered);
    }

    // Responsável por consultar um usuário por id no DB
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable int id) {
        User found = userService.findById(id);

        return ResponseEntity.ok(found);
    }

    // Responsável por consultar todos usuários no DB
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> found = userService.findAll();

        return ResponseEntity.ok(found);
    }

    // Responsável por consultar todas as transações de um usuário
    @GetMapping("/{id}/transactions")
    public ResponseEntity<List<Transaction>> findByUserId(@PathVariable int id) {
        // Valida se o usuário existe
        userService.findById(id);
        // Busca as transações através do service apropriado
        return ResponseEntity.ok(transactionService.findByUserId(id));
    }

    // Responsável por consultar todas as contas bancárias de um usuário
    @GetMapping("/{id}/bank-accounts")
    public ResponseEntity<List<BankAccount>> findBankAccountsByUserId(@PathVariable int id) {
        // Valida se o usuário existe
        userService.findById(id);
        // Busca as contas bancárias através do service apropriado
        return ResponseEntity.ok(bankAccountService.findByUserId(id));
    }

    // Responsável por consultar todas as transações de determinado tipo de um usuário
    @GetMapping("/{id}/transactions/transaction-types/{transactionTypeId}")
    public ResponseEntity<List<Transaction>> findByUserIdAndTransactionTypeId(@PathVariable int id, @PathVariable int transactionTypeId) {
        return ResponseEntity.ok(transactionService.findByUserIdAndTransactionTypeId(id, transactionTypeId));
    }

    // Responsável por atualizar um usuário no DB
    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable int id, @RequestBody User user) {
        User updated = userService.update(id, user);

        return ResponseEntity.ok(updated);
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