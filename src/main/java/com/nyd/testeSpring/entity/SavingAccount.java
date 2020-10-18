package com.nyd.testeSpring.entity;

public class SavingAccount extends  Account{
    private String type = "Saving";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
