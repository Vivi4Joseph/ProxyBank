package org.formation.controller;

import org.formation.entity.Transaction;
import org.formation.repository.CurrentAccountRepository;
import org.formation.repository.SavingAccountRepository;
import org.formation.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = {"http://localhost:4200"})
public class RestTransactionController {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    SavingAccountRepository savingAccountRepository;

    @Autowired
    CurrentAccountRepository currentAccountRepository;

    @GetMapping("from/{id}")
    public List<Transaction> getTransactionsFrom(@PathVariable("id") Long id) {
        return transactionRepository.findByAccount_from_Id(id);
    }

    @GetMapping("to/{id}")
    public List<Transaction> getTransactionsTo(@PathVariable("id") Long id) {
        return transactionRepository.findByAccount_to_Id(id);
    }

    @PostMapping("from/{from}/to/{to}")
    public Transaction create(
            @RequestBody Transaction transaction
    ) {
        if (transaction.getAccount_from().canMakeTransaction(transaction.getAmount())) {
            transaction.getAccount_to().setAmount(
                    transaction.getAccount_to().getAmount() + transaction.getAmount()
            );
            transaction.getAccount_from().setAmount(
                    transaction.getAccount_from().getAmount() - transaction.getAmount()
            );
            return transactionRepository.save(transaction);
        }

        return null;
    }
}
