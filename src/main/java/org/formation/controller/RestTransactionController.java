package org.formation.controller;

import org.formation.entity.Transaction;
import org.formation.repository.TransactionRepository;
import org.formation.service.BanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = {"http://localhost:4200"})
public class RestTransactionController {
    TransactionRepository transactionRepository;
    BanqueService banqueService;

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
        return banqueService.makeTransaction(transaction);
    }
}
