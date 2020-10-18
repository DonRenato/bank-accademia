package com.nyd.testeSpring.controller;

import com.nyd.testeSpring.entity.Account;
import com.nyd.testeSpring.entity.Transfer;
import com.nyd.testeSpring.repository.Database;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;

@RestController
public class TransferController {

    private Hashtable db = Database.INSTANCE.account();


    @PostMapping("/transfer")
    public ResponseEntity transfer(@RequestBody Transfer transfer){
        Account accountFrom = (Account) db.get(transfer.getNumberFrom());
        accountFrom.withdraw(transfer.getAmount());
        db.replace(accountFrom.getNumber(), accountFrom);

        Account accountTo = (Account) db.get((transfer.getNumberTo()));
        accountTo.deposit(transfer.getAmount());
        db.replace(accountTo.getNumber(), accountTo);

        return ResponseEntity.accepted().body(accountTo);
    }
}
