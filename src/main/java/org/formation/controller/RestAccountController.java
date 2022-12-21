package org.formation.controller;

import org.formation.entity.Account;
import org.formation.entity.Client;
import org.formation.entity.CurrentAccount;
import org.formation.entity.SavingAccount;
import org.formation.repository.CurrentAccountRepository;
import org.formation.repository.SavingAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = {"http://localhost:4200"})
public class RestAccountController {
	@Autowired
    SavingAccountRepository savingAccountRepository;

    @Autowired
    CurrentAccountRepository currentAccountRepository;

    @GetMapping("/current")
    public List<CurrentAccount> getCurrentAccount(){
    	return currentAccountRepository.findAll();
    }
    
    @GetMapping("/saving")
    public List<SavingAccount> getSavingAccount(){
    	return savingAccountRepository.findAll();
    }
    
    @GetMapping("/current/client/{id}")
    public List<Account> getCurrentAccountFromClient(@PathVariable("id") Long id) {
        return currentAccountRepository.findByClient_Id(id);
    }

    @GetMapping("/saving/client/{id}")
    public List<Account> getSavingAccountFromClient(@PathVariable("id") Long id) {
        return savingAccountRepository.findByClient_Id(id);
    }

    @PostMapping("/current/{id}/add/{sold}")
    public Account addSoldToCurrentAccount(@RequestBody CurrentAccount currentAccount,
    		@PathVariable("id") Long id, @PathVariable("sold") double sold) {
    	Optional<CurrentAccount> a = currentAccountRepository.findById(id);
    	
    	if (a.isPresent()) {
    		CurrentAccount effective_a = a.get();
	    	effective_a.setAmount(sold + currentAccount.getAmount());
	        return currentAccountRepository.save(effective_a);
		}

    	return null;
    }
    
    @PostMapping("/current")
    public Account createCurrentAccount(@RequestBody CurrentAccount currentAccount) {
        return currentAccountRepository.save(currentAccount);
    }

    @PostMapping("/saving")
    public Account createSavingAccount(@RequestBody SavingAccount savingAccount) {
        return savingAccountRepository.save(savingAccount);
    }

    @PutMapping("/current")
    public Account updateCurrentAccount(@RequestBody CurrentAccount currentAccount) {
        return currentAccountRepository.save(currentAccount);
    }

    @PutMapping("/saving")
    public Account updateSavingAccount(@RequestBody SavingAccount savingAccount) {
        return savingAccountRepository.save(savingAccount);
    }

}
