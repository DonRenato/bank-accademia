package com.nyd.testeSpring.controller;


import com.nyd.testeSpring.entity.CheckingAccount;
import com.nyd.testeSpring.entity.SavingAccount;
import com.nyd.testeSpring.repository.Database;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.UUID;

@RestController
public class CheckingAccountController {

   private Hashtable db = Database.INSTANCE.account();



    @GetMapping("/checking/{number}")
    public ResponseEntity<CheckingAccount> sayHelloWithName(@PathVariable String number){
        CheckingAccount account = (CheckingAccount) db.get(number);


        return ResponseEntity.ok(account);
    }

    @PostMapping("/checking")
    public ResponseEntity<CheckingAccount> createNewAccount(@RequestBody CheckingAccount account){
        var type = account.getType();
        UUID id = UUID.randomUUID();
        account.setNumber(id.toString());


        var newAccount = db.put(id.toString(), account );


        return ResponseEntity.created(URI.create("/account/" + newAccount)).body(account);
    }



}
