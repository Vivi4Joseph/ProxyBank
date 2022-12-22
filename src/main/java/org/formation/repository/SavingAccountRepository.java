package org.formation.repository;

import org.formation.entity.Account;
import org.formation.entity.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SavingAccountRepository extends JpaRepository<SavingAccount, Long> {

    Optional<Account> findById(String s);

    List<SavingAccount> findByClient_Id(Long id);

    void deleteById(String s);
}
