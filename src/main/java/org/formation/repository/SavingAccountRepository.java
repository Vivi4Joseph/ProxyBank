package org.formation.repository;

import org.formation.entity.Account;
import org.formation.entity.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SavingAccountRepository extends JpaRepository<SavingAccount, Long> {

    Optional<Account> findById(String s);

    List<Account> findByClient_Id(Long id);

    void deleteById(String s);
}
