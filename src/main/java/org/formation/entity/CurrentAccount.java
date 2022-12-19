package org.formation.entity;

import java.util.ArrayList;
import java.util.Date;



public class CurrentAccount extends Account {
	private int limitAmount;

	
	
	public CurrentAccount(double amount, Date date, int limit_amount) {
		super(amount, date);
		this.limitAmount = limit_amount; //1000
	}
	
	public CurrentAccount(double amount, Date date) {
		this(amount, date, 200);
		// TODO Auto-generated constructor stub
	}

	public int getLimit_amount() {
		return limitAmount;
	}


	public void setLimit_amount(int limitAmount) {
		this.limitAmount = limitAmount;
	}
	@Override
	public String toString() {
		return "CurrentAccount [limitAmount=" + limitAmount + ", getAmount()=" + getAmount() + ", "
				+ (getDate() != null ? "getDate()=" + getDate() : "") + "]";
	}
	
	






}
