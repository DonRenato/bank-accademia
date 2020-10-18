package com.nyd.testeSpring.controller;

import com.nyd.testeSpring.entity.Account;
import com.nyd.testeSpring.entity.Withdraw;
import com.nyd.testeSpring.repository.Database;
import java.util.Hashtable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WithdrawController {
    private Hashtable db = Database.INSTANCE.account();


    @PostMapping("/withdraw")
    public ResponseEntity withdraw(@RequestBody Withdraw withdraw){
        Account account = (Account) db.get(withdraw.getNumber());
        account.withdraw(withdraw.getAmount());

        db.replace(account.getNumber(), account);

        return ResponseEntity.ok(account);

    }
}
