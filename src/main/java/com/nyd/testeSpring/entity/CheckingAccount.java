package com.nyd.testeSpring.entity;

public class CheckingAccount extends Account {
    private String type = "Checking";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
