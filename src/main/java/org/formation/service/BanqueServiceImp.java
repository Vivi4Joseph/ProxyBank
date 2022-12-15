package org.formation.service;

import java.util.Date;

import org.formation.entity.Account;
import org.formation.entity.CurrentAccount;
import org.formation.entity.Operation;
import org.formation.entity.Retrait;
import org.formation.entity.Versement;
import org.formation.repository.AccountRepository;
import org.formation.repository.OperationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BanqueServiceImp implements BanqueService {

	AccountRepository accountRepository;
	
	OperationRepository operationRepository;
	
	@Override
	public Account consulterAccount(String codeCte) {
		Account account = consulterAccount(codeCte);
		if(account == null) throw new RuntimeException("Account Introuvable");
		return account;
	}
	

	@Override
	public void verser(String codeCte, double montant) {
		Account account = consulterAccount(codeCte);
		Versement versement = new Versement(new Date(), montant,account);
		operationRepository.save(versement);
		account.setAmount(account.getAmount()+montant);
		accountRepository.save(account);	
	}

	@Override
	public void retirer(String codeCte, double montant) {
		Account account = consulterAccount(codeCte);
		Retrait retrait = new Retrait(new Date(),montant,account);
		double faciliteCaisse=0;
		if(account instanceof CurrentAccount)
			faciliteCaisse = ((CurrentAccount)account).getLimit_amount();
		if(account.getAmount()+faciliteCaisse<montant)
			throw new RuntimeException("Solde insufficant !");
		operationRepository.save(retrait);
		account.setAmount(account.getAmount()-montant);
		accountRepository.save(account);		
	}

	@Override
	public void virement(String codeCte1, String codeCte2, double montant) {
		if(codeCte1.equals(codeCte2))
			throw new RuntimeException("impossible de virer dans le même account!");
		retirer(codeCte1, montant);
		verser(codeCte2, montant);
		
	}

	@Override
	public Page<Operation> listOperation(String codeCte, int page, int size) {
		return operationRepository.listOperation(codeCte, new 
				PageRequest(page, size));
	}
}
