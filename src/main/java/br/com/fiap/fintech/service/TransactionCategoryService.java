package br.com.fiap.fintech.service;

import br.com.fiap.fintech.model.TransactionCategory;
import br.com.fiap.fintech.repository.TransactionCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionCategoryService {
    @Autowired
    private TransactionCategoryRepository transactionCategoryRepository;

    public TransactionCategory register(TransactionCategory category) {
        return transactionCategoryRepository.save(category);
    }

    public TransactionCategory findById(int id) {
        Optional<TransactionCategory> category = transactionCategoryRepository.findById(id);

        if (category.isPresent()) {
            return category.get();
        } else {
            throw new RuntimeException("Categoria de transação não encontrada!");
        }
    }

    public List<TransactionCategory> findAll() {
        return transactionCategoryRepository.findAll();
    }

    public TransactionCategory update(int id, TransactionCategory category) {
        Optional<TransactionCategory> existent = transactionCategoryRepository.findById(id);

        if (existent.isPresent()) {
            return transactionCategoryRepository.save(category);
        } else {
            throw new RuntimeException("Erro ao atualizar: categoria de transação não encontrada!");
        }
    }

    public void delete(int id) {
        Optional<TransactionCategory> category = transactionCategoryRepository.findById(id);

        if (category.isPresent()) {
            transactionCategoryRepository.deleteById(id);
        } else {
            throw new RuntimeException("Erro ao excluir: categoria de transação não encontrada!");
        }
    }
}