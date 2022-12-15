package org.formation.entity;

import java.util.Date;

public class SavingAccount extends Account{
	
	private int interest;

	@Override
	public String toString() {
		return "SavingAccount [interest=" + interest + ", getAmount()=" + getAmount() + ", "
				+ (getDate() != null ? "getDate()=" + getDate() + ", " : "")
				+ (getClient() != null ? "getClient()=" + getClient() : "") + "]";
	}



	public int getTax() {
		return interest;
	}



	public void setTax(int tax) {
		this.interest = tax;
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
