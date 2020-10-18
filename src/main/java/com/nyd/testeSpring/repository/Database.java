package com.nyd.testeSpring.repository;

import com.nyd.testeSpring.entity.Account;


import java.util.Hashtable;

public enum Database {
    INSTANCE;


    private final Hashtable<String, Account> account;



    Database(){
        account = new Hashtable<>();
    }

    public Hashtable account(){
        return  this.account;
    }
}
