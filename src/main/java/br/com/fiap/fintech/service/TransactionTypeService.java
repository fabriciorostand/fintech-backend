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
import java.util.Optional;

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
        Optional<TransactionType> type = transactionTypeRepository.findById(id);

        if (type.isPresent()) {
            return type.get();
        } else {
            throw new RuntimeException("Tipo de transação não encontrado!");
        }
    }

    public List<TransactionType> findAll() {
        return transactionTypeRepository.findAll();
    }

    @Transactional
    public TransactionType update(Long id, UpdateTTRequest request) {
        TransactionType transactionType = transactionTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tipo de lançamento não encontrado"));

        transactionType.updateInfo(request);

        return transactionType;
    }

    public void delete(Long id) {
        Optional<TransactionType> type = transactionTypeRepository.findById(id);

        if (type.isPresent()) {
            transactionTypeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Erro ao excluir: tipo de transação não encontrado!");
        }
    }
}