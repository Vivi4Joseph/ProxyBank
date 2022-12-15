package org.formation.entity;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Versement extends Operation{

	public Versement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Versement(Date dateOp, double montant, Account account) {
		super(dateOp, montant, account);
		// TODO Auto-generated constructor stub
	}
	public Versement(long numero, Date dateOp, double montant, Account account) {
		super(numero, dateOp, montant, account);
		// TODO Auto-generated constructor stub
	}

	
}
