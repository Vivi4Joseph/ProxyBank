package org.formation.entity;

import java.util.ArrayList;
import java.util.Date;


public class CurrentAccount extends Account {
    private int decouvert;

    public CurrentAccount(double amount, Date date, int decouvert) {
        super(amount, date);
        this.decouvert = decouvert;
    }

    public CurrentAccount(double amount, Date date) {
        this(amount, date, 200);
    }

    public int getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(int decouvert) {
        this.decouvert = decouvert;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "decouvert=" + decouvert +
                '}';
    }
}
