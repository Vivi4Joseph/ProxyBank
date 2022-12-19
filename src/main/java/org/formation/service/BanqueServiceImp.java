package org.formation.service;

import org.formation.entity.Transaction;
import org.formation.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BanqueServiceImp implements BanqueService {
    TransactionRepository transactionRepository;

    @Override
    public Transaction makeTransaction(Transaction transaction) {
        if (transaction.getAccountFrom().canMakeTransaction(transaction.getAmount())) {
            transaction.getAccountTo().setAmount(
                    transaction.getAccountTo().getAmount() + transaction.getAmount()
            );
            transaction.getAccountFrom().setAmount(
                    transaction.getAccountFrom().getAmount() - transaction.getAmount()
            );
            return transactionRepository.save(transaction);
        }

        return null;
    }
}
