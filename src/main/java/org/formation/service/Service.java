package org.formation.service;

import org.formation.entity.Account;
import org.formation.entity.Client;

public interface Service {
	/**
	 * Cree des Client 
	 * @param client
	 */
	void createClient(Client client);
	
	/**
	 * Creation des Compte
	 * @param client
	 * @param account
	 */
	public void associateClientAccount(Client client, Account account);
	
	/**
	 * Modifier les Compte
	 * @param account
	 * @return
	 */
	Account modifyAccount(Account account);
	
	/**
	 * Lire les Compte
	 * @param account
	 * @return
	 */
	Account readAccount(Account account);
	
	/**
	 * Lire les Client
	 * @param client
	 * @return
	 */
	Client readClient(Client client);
	
	/**
	 * Supprimer Compte
	 * @param account
	 */
	void deleteAccount(Account account);	
	
	/**
	 * Faire audit de tous les compte
	 */
	void do_audit();
	
}
