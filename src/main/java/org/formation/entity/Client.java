 package org.formation.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Client extends Personne  {
	
	private String login;
	
	private String motDePasse;
	
	@Embedded
	private Adresse adresse;
	
	
	
	public Client() {}

	public Client(Adresse adresse) {
	    this.adresse = adresse;
	}
	

	public Client(String nom, String prenom, String login, String motDePasse, Adresse adresse) {
		super(nom,prenom);
		this.login = login;
		this.motDePasse = motDePasse;
		this.adresse = adresse;
	}

	public String toString() {
		 return " ID  : "+this.getId() +" - "+
		    	" Nom : "+this.getNom()+" - "+
		    	" Prénom : "+this.getPrenom() +" - "+
		    	" login : "+this.getLogin() +" - "+
		    	" Mot de passe : "+this.getMotDePasse() +" - "/*+
		    	" Adresse : "+this.getAdresse().toString()*/;
		    		
		
	}


	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	

  
}
