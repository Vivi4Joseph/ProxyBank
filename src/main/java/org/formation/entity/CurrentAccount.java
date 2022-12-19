package org.formation.entity;

import jakarta.persistence.Entity;

import java.util.Date;


@Entity
public class CurrentAccount extends Account {
    private double overdraft;

    public CurrentAccount(double amount, Date date, int decouvert) {
        super(amount, date);
        this.overdraft = decouvert;
    }

    public CurrentAccount(double amount, Date date) {
        this(amount, date, 200);
    }

    public CurrentAccount() {

    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public boolean canMakeTransaction(double amount) {
        return this.getAmount() - amount >= - this.overdraft;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "decouvert=" + overdraft +
                '}';
    }
}
