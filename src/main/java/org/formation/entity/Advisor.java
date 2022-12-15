package org.formation.entity;

import java.util.ArrayList;
import java.util.List;



public class Advisor extends Personne{
	private final List<Client> clients = new ArrayList<>();
	
	

	public Advisor() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Advisor(Long id, String nom, String prenom) {
		super(id, nom, prenom);
		// TODO Auto-generated constructor stub
	}



	public Advisor(String nom, String prenom) {
		super(nom, prenom);
		// TODO Auto-generated constructor stub
	}



	public List<Client> getClients() {
		return clients;
	}
	
	
}
