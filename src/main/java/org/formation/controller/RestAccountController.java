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

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = {"http://localhost:4200"})
public class RestAccountController {
    SavingAccountRepository savingAccountRepository;

    CurrentAccountRepository currentAccountRepository;

    @GetMapping("current/{id}")
    public List<Account> getCurrentAccountFromClient(@PathVariable("id") Long id) {
        return currentAccountRepository.findByClient_Id(id);
    }

    @GetMapping("saving/{id}")
    public List<Account> getSavingAccountFromClient(@PathVariable("id") Long id) {
        return savingAccountRepository.findByClient_Id(id);
    }

    @PostMapping("current")
    public Account createCurrentAccount(@RequestBody CurrentAccount currentAccount) {
        return currentAccountRepository.save(currentAccount);
    }

    @PostMapping("saving")
    public Account createSavingAccount(@RequestBody SavingAccount savingAccount) {
        return savingAccountRepository.save(savingAccount);
    }

    @PutMapping("current")
    public Account updateCurrentAccount(@RequestBody CurrentAccount currentAccount) {
        return currentAccountRepository.save(currentAccount);
    }

    @PutMapping("saving")
    public Account updateSavingAccount(@RequestBody SavingAccount savingAccount) {
        return savingAccountRepository.save(savingAccount);
    }
}
