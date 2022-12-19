package org.formation.repository;

import org.formation.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {

    @Override
    Optional<Account> findById(String s);

    @Override
    boolean existsById(String s);

    @Override
    void deleteById(String s);
}
