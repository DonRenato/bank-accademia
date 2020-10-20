package com.nyd.testeSpring.entity;

import java.util.UUID;

public abstract class Account {
    private String number;
    private String name;
    private double amount;


    public Account(){
        this.number = UUID.randomUUID().toString();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void withdraw(double amountWithdraw) {
        this.amount -= amountWithdraw;

    }

    public void deposit(double amountDeposit) {
        this.amount += amountDeposit;

    }
}
