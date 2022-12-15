package org.formation.entity;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Retrait extends Operation{
	public Retrait() {
		super();
	}

	public Retrait(long numero, Date dateOp, double montant, Account account) {
		super(numero, dateOp, montant, account);
		// TODO Auto-generated constructor stub
	}

	public Retrait(Date dateOp, double montant, Account account) {
		super(dateOp, montant, account);
		// TODO Auto-generated constructor stub
	}
	
	
}
