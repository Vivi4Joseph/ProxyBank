package org.formation.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Account  {
	@Id
	private int id;
	private double amount;
	private Date date;
	
	@ManyToOne
	private Client client;
	
	public Account(double amount, Date date) {
		super();
		this.amount = amount;
		this.date = date;
	}

	public Account() {
		super();
	}

	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
}
