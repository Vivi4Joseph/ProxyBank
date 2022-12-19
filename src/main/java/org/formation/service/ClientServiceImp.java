package org.formation.service;

import org.formation.entity.Account;
import org.formation.entity.Client;
import org.formation.repository.AccountRepository;
import org.formation.repository.ClientRepository;
import org.springframework.data.domain.Page;

public class ClientServiceImp implements ClientService{

	ClientRepository clientRepository;
	AccountRepository accountRepository;
	
	@Override
	public Client consulterClient(Long codeClt) {
		return clientRepository.findOne(codeClt);
	}

	@Override
	public void supprimerClient(Long codeClt) {
		clientRepository.delete(codeClt);
	}

	@Override
	public Client ajouter(Client c) {
		return clientRepository.save(c);
	}

	@Override
	public Page<Account> listeAccount(Long codeClt, int page, int size) {
		return accountRepository.listAccount(codeClt, new PageRequest(page,size));
	}

}
