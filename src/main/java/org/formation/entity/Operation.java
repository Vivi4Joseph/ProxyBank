package org.formation.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public abstract class Operation implements Serializable {

	private long numero;
	private Date dateOp;
	private double montant;
	
	@ManyToOne
	@JoinColumn(name="Code_CPT")
	private Account account;
	
	public Operation() {
		super();
	}

	public Operation(long numero, Date dateOp, double montant, Account account) {
		super();
		this.numero = numero;
		this.dateOp = dateOp;
		this.montant = montant;
		this.account = account;
	}

	
	
	public Operation(Date dateOp, double montant, Account account) {
		super();
		this.dateOp = dateOp;
		this.montant = montant;
		this.account = account;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public Date getDateOp() {
		return dateOp;
	}

	public void setDateOp(Date dateOp) {
		this.dateOp = dateOp;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Operation [numero=" + numero + ", " + (dateOp != null ? "dateOp=" + dateOp + ", " : "") + "montant="
				+ montant + ", " + (account != null ? "account=" + account : "") + "]";
	}
	
	
	
}
