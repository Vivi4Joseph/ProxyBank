package org.formation.entity;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class SavingAccount extends Account{
	private int interest;

	public SavingAccount() {

	}
	
	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	public SavingAccount(double amount, Date date, int interest) {
		super(amount, date);
		this.interest = (int) (amount/2);
	}

	public SavingAccount(double amount, Date date) {
		super(amount, date);
		// TODO Auto-generated constructor stub
	}
}
