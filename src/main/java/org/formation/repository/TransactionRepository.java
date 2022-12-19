package org.formation.repository;

import org.formation.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccount_from_Id(Long id);

    List<Transaction> findByAccount_to_Id(Long id);
}
