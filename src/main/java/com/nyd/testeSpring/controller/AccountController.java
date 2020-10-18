package com.nyd.testeSpring.controller;


import com.nyd.testeSpring.entity.Account;
import com.nyd.testeSpring.repository.Database;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.UUID;

@RestController
public class AccountController {

   private Hashtable db = Database.INSTANCE.account();

    @GetMapping("/account")
    public ResponseEntity<ArrayList<Account>> getAll(){
        ArrayList<Account> accounts =
                new ArrayList<Account>(db.values());


        return ResponseEntity.ok(accounts);
    }

    /*@PostMapping("/deposit/{number}")
    public ResponseEntity<Account> deposit (@PathVariable String number, @RequestBody double depositAmount) {
        Account account = (Account) db.get(number);
        account.deposit(depositAmount);
        return ResponseEntity.accepted().body(account);
    }*/

}
