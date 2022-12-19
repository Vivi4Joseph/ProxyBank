package org.formation.repository;

import org.formation.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountFrom_Id(Long id);

    List<Transaction> findByAccountTo_Id(Long id);
}
