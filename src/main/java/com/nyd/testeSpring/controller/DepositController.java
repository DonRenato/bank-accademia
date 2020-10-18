package com.nyd.testeSpring.controller;

import com.nyd.testeSpring.entity.Account;
import com.nyd.testeSpring.entity.Deposit;
import com.nyd.testeSpring.repository.Database;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;

@RestController
public class DepositController {

    private Hashtable db = Database.INSTANCE.account();

    @PostMapping("/deposit")
    public ResponseEntity deposit(@RequestBody Deposit deposit){
        Account account = (Account) db.get(deposit.getNumber());
        account.deposit(deposit.getAmount());

        db.replace(account.getNumber(), account);

        return ResponseEntity.ok(account);
    }
}
