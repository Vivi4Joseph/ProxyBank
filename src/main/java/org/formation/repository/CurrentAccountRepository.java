package org.formation.repository;

import org.formation.entity.Account;
import org.formation.entity.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long> {

    Optional<Account> findById(String s);

    List<Account> findByClient_Id(Long id);

    void deleteById(String s);
}
