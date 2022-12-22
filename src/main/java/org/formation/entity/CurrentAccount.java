package org.formation.entity;

import jakarta.persistence.Entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CurrentAccount extends Account implements Serializable {
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
    	System.out.println(this.getAmount());
    	System.out.println(amount);
    	System.out.println(this.getOverdraft());

        return this.getAmount() - amount >= - this.overdraft;
    }
}
