package org.formation.repository;

import org.formation.entity.Account;
import org.formation.entity.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findById(Long s);
    List<CurrentAccount> findByClient_Id(Long id);

    void deleteById(Long id);
}
