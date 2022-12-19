package org.formation.controller;

import org.formation.entity.Client;
import org.formation.entity.Transaction;
import org.formation.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = {"http://localhost:4200"})
public class RestTransactionController {
    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("from/{id}")
    public List<Transaction> getTransactionsFrom(@PathVariable("id") Long id) {
        return transactionRepository.findByAccount_from_Id(id);
    }

    @GetMapping("to/{id}")
    public List<Transaction> getTransactionsTo(@PathVariable("id") Long id) {
        return transactionRepository.findByAccount_to_Id(id);
    }
}