package br.com.fiap.fintech.service;

import br.com.fiap.fintech.dto.transaction_type.CreateTTRequest;
import br.com.fiap.fintech.dto.transaction_type.UpdateTTRequest;
import br.com.fiap.fintech.model.TransactionType;
import br.com.fiap.fintech.repository.TransactionTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionTypeService {
    // Attributes
    private final TransactionTypeRepository transactionTypeRepository;

    // Methods
    @Transactional
    public TransactionType register(CreateTTRequest request) {
        TransactionType transactionType = new TransactionType(request);

        return transactionTypeRepository.save(transactionType);
    }

    public TransactionType findById(Long id) {
        return transactionTypeRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<TransactionType> findAll() {
        return transactionTypeRepository.findAll();
    }

    @Transactional
    public TransactionType update(Long id, UpdateTTRequest request) {
        TransactionType transactionType = transactionTypeRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        transactionType.updateInfo(request);

        return transactionType;
    }

    @Transactional
    public void delete(Long id) {
        transactionTypeRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        transactionTypeRepository.deleteById(id);
    }
}