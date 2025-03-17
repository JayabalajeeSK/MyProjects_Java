package com.jb.banking_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jb.banking_app.dto.AccountDto;
import com.jb.banking_app.service.AccountService;

@Controller
@RequestMapping
public class AccountController {

    private AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
//////////////////////////////////// 
    // Add Account Rest API
    @PostMapping("/api/accounts")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto)
    {
        return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
    }
}