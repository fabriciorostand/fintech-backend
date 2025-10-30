package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.TransactionType;
import br.com.fiap.fintech.repository.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionTypeService {
    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    public TransactionType register(TransactionType type) {
        return transactionTypeRepository.save(type);
    }

    public TransactionType findById(int id) {
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

    public TransactionType update(int id, TransactionType type) {
        Optional<TransactionType> existent = transactionTypeRepository.findById(id);

        if (existent.isPresent()) {
            return transactionTypeRepository.save(type);
        } else {
            throw new RuntimeException("Erro ao atualizar: tipo de transação não encontrado!");
        }
    }

    public void delete(int id) {
        Optional<TransactionType> type = transactionTypeRepository.findById(id);

        if (type.isPresent()) {
            transactionTypeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Erro ao excluir: tipo de transação não encontrado!");
        }
    }
}