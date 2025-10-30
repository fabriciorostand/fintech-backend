package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.Transaction;
import br.com.fiap.fintech.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction register(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction findById(int id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);

        if (transaction.isPresent()) {
            return transaction.get();
        } else {
            throw new RuntimeException("Transação não encontrada!");
        }
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Transaction update(int id, Transaction transaction) {
        Optional<Transaction> existent = transactionRepository.findById(id);

        if (existent.isPresent()) {
            return transactionRepository.save(transaction);
        } else {
            throw new RuntimeException("Erro ao atualizar: transação não encontrada!");
        }
    }

    public void delete(int id) {
        Optional<Transaction> transaction = transactionRepository.findById(id);

        if (transaction.isPresent()) {
            transactionRepository.deleteById(id);
        } else {
            throw new RuntimeException("Erro ao excluir: transação não encontrada!");
        }
    }
}