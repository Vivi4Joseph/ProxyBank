package org.formation.entity;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Client extends Personne {
    private String login;

    private String motDePasse;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Collection<Account> accounts;

    public Client() {
    }

    public Client(String nom, String prenom, String login, String motDePasse) {
        super(nom, prenom);
        this.login = login;
        this.motDePasse = motDePasse;
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

	public Collection<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Collection<Account> accounts) {
		this.accounts = accounts;
	}
}
