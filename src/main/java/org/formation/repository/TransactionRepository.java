package org.formation.repository;

import org.formation.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccount_from_Id(Long id);

    List<Transaction> findByAccount_to_Id(Long id);
}
