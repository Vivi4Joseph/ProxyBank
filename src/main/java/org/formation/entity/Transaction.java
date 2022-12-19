package org.formation.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private double amount;

    @ManyToOne
    @JoinColumn(name = "account_from")
    private Account accountFrom;

    @ManyToOne
    @JoinColumn(name = "account_to")
    private Account accountTo;

    public Transaction() {
        super();
    }

    public Transaction(Long id, double montant, Account account_from, Account account_to) {
        this.id = id;
        this.amount = montant;
        this.accountFrom = account_from;
        this.accountTo = account_to;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(Account account_from) {
        this.accountFrom = account_from;
    }

    public Account getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Account account_to) {
        this.accountTo = account_to;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", montant=" + amount +
                ", account_from=" + accountFrom +
                ", account_to=" + accountTo +
                '}';
    }
}
