package org.formation.service;

import org.formation.entity.Account;
import org.formation.entity.Client;
import org.springframework.data.domain.Page;

public interface ClientService {
	 public Client consulterClient(Long codeClt);
	 
	 public void supprimerClient(Long codeClt);
	 
	 public Client ajouter(Client c);
	 
	 public Page<Account> listeAccount(Long codeClt, int page , int size);
}