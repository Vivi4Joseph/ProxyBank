package org.formation.entity;

import java.io.Serializable;

import jakarta.persistence.*;

public abstract class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private double amount;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_FROM")
    private Account account_from;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_TO")
    private Account account_to;

    public Transaction() {
        super();
    }

    public Transaction(int id, double montant, Account account_from, Account account_to) {
        this.id = id;
        this.amount = montant;
        this.account_from = account_from;
        this.account_to = account_to;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getAccount_from() {
        return account_from;
    }

    public void setAccount_from(Account account_from) {
        this.account_from = account_from;
    }

    public Account getAccount_to() {
        return account_to;
    }

    public void setAccount_to(Account account_to) {
        this.account_to = account_to;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", montant=" + amount +
                ", account_from=" + account_from +
                ", account_to=" + account_to +
                '}';
    }
}
