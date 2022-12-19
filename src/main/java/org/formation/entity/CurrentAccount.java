package org.formation.entity;

import java.util.Date;


public class CurrentAccount extends Account {
    private int overdraft;

    public CurrentAccount(double amount, Date date, int decouvert) {
        super(amount, date);
        this.overdraft = decouvert;
    }

    public CurrentAccount(double amount, Date date) {
        this(amount, date, 200);
    }

    public int getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(int overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "decouvert=" + overdraft +
                '}';
    }
}
