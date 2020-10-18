package com.nyd.testeSpring.controller;


import com.nyd.testeSpring.entity.Account;
import com.nyd.testeSpring.entity.SavingAccount;
import com.nyd.testeSpring.repository.Database;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.UUID;

@RestController
public class SavingAccountController {

   private Hashtable db = Database.INSTANCE.account();



    @GetMapping("/saving/{number}")
    public ResponseEntity<SavingAccount> sayHelloWithName(@PathVariable String number){
        SavingAccount account = (SavingAccount) db.get(number);


        return ResponseEntity.ok(account);
    }

    @PostMapping("/saving")
    public ResponseEntity<SavingAccount> createNewAccount(@RequestBody SavingAccount account){
        UUID id = UUID.randomUUID();
        account.setNumber(id.toString());

        var newAccount = db.put(id.toString(), account );

        return ResponseEntity.created(URI.create("/account/" + newAccount)).body(account);
    }


}
