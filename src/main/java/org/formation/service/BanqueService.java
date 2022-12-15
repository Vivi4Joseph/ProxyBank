package org.formation.service;

import org.formation.entity.Account;
import org.formation.entity.Operation;
import org.springframework.data.domain.Page;

public interface BanqueService {
		public Account consulterAccount(String codeCte);
		public void verser(String codeCte,double montant);
		public void retirer(String codeCte,double montant);
		public void virement(String codeCte1, String codeCte2, double montant);
		public Page<Operation> listOperation(String codeCte,int page , int size);
}
