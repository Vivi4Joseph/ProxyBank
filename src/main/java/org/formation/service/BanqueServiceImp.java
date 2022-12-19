package org.formation.service;

import org.formation.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BanqueServiceImp implements BanqueService {
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Account consulterAccount(String codeCte) {
		return null;
	}
}
