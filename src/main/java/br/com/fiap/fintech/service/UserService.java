package br.com.fiap.fintech.service;

import br.com.fiap.fintech.dto.register.RegisterRequest;
import br.com.fiap.fintech.dto.user.UpdateUserRequest;
import br.com.fiap.fintech.model.User;
import br.com.fiap.fintech.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    // Attributes
    private final UserRepository userRepository;

    // Methods
    @Transactional
    public User register(RegisterRequest request) {
        User user = new User(request);

        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User update(Long id, UpdateUserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        user.updateInfo(request);

        return user;
    }

    @Transactional
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        userRepository.delete(user);
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