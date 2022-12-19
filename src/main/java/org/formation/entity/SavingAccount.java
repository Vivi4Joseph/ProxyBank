package org.formation.entity;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class SavingAccount extends Account{
	private int interest;

	public SavingAccount() {

	}

	@Override
	public String toString() {
		return "SavingAccount [interest=" + interest + ", getAmount()=" + getAmount() + ", "
				+ (getDate() != null ? "getDate()=" + getDate() + ", " : "")
				+ (getClient() != null ? "getClient()=" + getClient() : "") + "]";
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
