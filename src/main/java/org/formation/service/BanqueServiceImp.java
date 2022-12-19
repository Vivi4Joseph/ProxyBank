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
        if (transaction.getAccount_from().canMakeTransaction(transaction.getAmount())) {
            transaction.getAccount_to().setAmount(
                    transaction.getAccount_to().getAmount() + transaction.getAmount()
            );
            transaction.getAccount_from().setAmount(
                    transaction.getAccount_from().getAmount() - transaction.getAmount()
            );
            return transactionRepository.save(transaction);
        }

        return null;
    }
}
