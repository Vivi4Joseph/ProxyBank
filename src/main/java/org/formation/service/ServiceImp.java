package org.formation.service;

import org.formation.entity.Account;
import org.formation.entity.Client;
import org.formation.repository.AccountRepository;
import org.formation.repository.ClientRepository;

public class ServiceImp implements Service{

	ClientRepository clientRepository;
	AccountRepository accountRepository;
	@Override
	public  createClient(Client client) {
			return clientRepository.save(client);
	}

	@Override
	public void associateClientAccount(Client client, Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account modifyAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account readAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client readClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void do_audit() {
		// TODO Auto-generated method stub
		
	}

}
