package com.jb.banking_app.service.impl;

import org.springframework.stereotype.Service;

import com.jb.banking_app.dto.AccountDto;
import com.jb.banking_app.entity.Account;
import com.jb.banking_app.mapper.AccountMapper;
import com.jb.banking_app.repository.AccountRepository;
import com.jb.banking_app.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account=AccountMapper.mapToAccount(accountDto);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
        
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Does not exist"));
        double total = account.getBalance() + amount; ////
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Does not exist"));
        if(account.getBalance()<amount)
        {
            throw new RuntimeException("Insufficient amount");
        }
        double total = account.getBalance() - amount; ////
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);

    }
}