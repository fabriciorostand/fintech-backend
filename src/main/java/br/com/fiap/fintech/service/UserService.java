package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.User;
import br.com.fiap.fintech.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    // Attributes
    private final UserRepository userRepository;

    // Methods
    public User register(User user) {
        return userRepository.save(user);
    }

    public User findById(int id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User update(int id, User user) {
        Optional<User> existentUser = userRepository.findById(id);

        if (existentUser.isPresent()) {
            return userRepository.save(user);
        } else {
            throw new RuntimeException("Erro ao atualizar: usuário não encontrado!");
        }
    }

    public void delete(int id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("Erro ao excluir: usuário não encontrado!");
        }
    }

    public User authenticate(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user.get();
        } else {
            throw new RuntimeException("Erro ao autenticar: email ou senha inválidos!");
        }
    }
}