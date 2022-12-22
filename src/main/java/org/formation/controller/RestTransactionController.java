package org.formation.controller;

import org.formation.entity.Account;
import org.formation.entity.CurrentAccount;
import org.formation.entity.Transaction;
import org.formation.repository.AccountRepository;
import org.formation.repository.CurrentAccountRepository;
import org.formation.repository.SavingAccountRepository;
import org.formation.repository.TransactionRepository;
import org.formation.service.BanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
// @CrossOrigin(origins = {"http://localhost:4200"})
public class RestTransactionController {
	@Autowired
    TransactionRepository transactionRepository;
	
	@Autowired
    AccountRepository accountRepository;
    
	@Autowired
	BanqueService banqueService;

    @GetMapping("from/{id}")
    public List<Transaction> getTransactionsFrom(@PathVariable("id") Long id) {
        return transactionRepository.findByAccountFrom_Id(id);
    }

    @GetMapping("to/{id}")
    public List<Transaction> getTransactionsTo(@PathVariable("id") Long id) {
        return transactionRepository.findByAccountTo_Id(id);
    }

    @PostMapping("from/{from}/to/{to}")
    public Transaction create(
            @RequestBody Transaction transaction, @PathVariable("from") Long from,  @PathVariable("to") Long to
    ) {
    	Account from_ = accountRepository.findById(from).get();
    	Account to_ = accountRepository.findById(to).get();
    	
    	if (from_ instanceof CurrentAccount c) {
    		System.out.println(from_);
    	}

    	transaction.setAccountFrom(from_);
    	transaction.setAccountTo(to_);
    	return banqueService.makeTransaction(transaction);
    }
}
