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
    @ResponseStatus(HttpStatus.CREATED)
    public User register(@RequestBody User user) {
        return userService.register(user);
    }

    // Responsável por consultar um usuário por id no DB
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable int id) {
        return userService.findById(id);
    }

    // Responsável por consultar todos usuários no DB
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll() {
        return userService.findAll();
    }

    // Responsável por consultar todas as transações de um usuário
    @GetMapping("/{id}/transactions")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> findByUserId(@PathVariable int id) {
        // Valida se o usuário existe
        userService.findById(id);
        // Busca as transações através do serviço apropriado
        return transactionService.findByUserId(id);
    }

    // Responsável por consultar todas as contas bancárias de um usuário
    @GetMapping("/{id}/bank-accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<BankAccount> findBankAccountsByUserId(@PathVariable int id) {
        // Valida se o usuário existe
        userService.findById(id);
        // Busca as contas bancárias através do serviço apropriado
        return bankAccountService.findByUserId(id);
    }

    // Responsável por consultar todas as transações de um usuário de determinado tipo
    @GetMapping("/{id}/transactions/transaction-types/{transactionTypeId}")
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> findByUserIdAndTransactionTypeId(@PathVariable int id, @PathVariable int transactionTypeId) {
        return transactionService.findByUserIdAndTransactionTypeId(id, transactionTypeId);
    }

    // Responsável por atualizar um usuário no DB
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User update(@PathVariable int id, @RequestBody User user) {
        return userService.update(id, user);
    }

    // Responsável por excluir um usuário no DB
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }

    // Responsável por autenticar um usuário
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        User user = userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        if (user != null) {
            LoginResponse response = new LoginResponse(
                    true,
                    "Login realizado com sucesso!",
                    user.getId(),
                    user.getName()
            );
            return ResponseEntity.ok(response);
        } else {
            LoginResponse response = new LoginResponse(
                    false,
                    "Email ou senha inválidos!",
                    null,
                    null
            );
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}