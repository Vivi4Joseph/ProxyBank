package org.formation.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Account implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private double amount;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean canMakeTransaction(double amount) {
		return this.amount - amount >= 0.;
	}
}
