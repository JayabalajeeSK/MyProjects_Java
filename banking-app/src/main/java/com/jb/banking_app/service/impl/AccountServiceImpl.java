package com.jb.banking_app.service.impl;

import java.time.LocalDateTime;
//import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jb.banking_app.dto.AccountDto;
import com.jb.banking_app.dto.TransferFundDto;
import com.jb.banking_app.entity.Account;
import com.jb.banking_app.entity.Transaction;
import com.jb.banking_app.exception.AccountException;
import com.jb.banking_app.mapper.AccountMapper;
import com.jb.banking_app.repository.AccountRepository;
import com.jb.banking_app.repository.TransactionRepository;
import com.jb.banking_app.service.AccountService;
@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    private static final String TRANSACTION_TYPE_DEPOSIT = "DEPOSIT";
    private static final String TRANSACTION_TYPE_WITHDRAW = "WITHDRAW";
        
        public AccountServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
            this.accountRepository = accountRepository; 
            this.transactionRepository = transactionRepository;//
        }
    
        @Override
        public List<AccountDto> getAllAccounts() {
            List<Account> accounts = accountRepository.findAll();
            return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account))
                                                            .collect(Collectors.toList());
        }
    
        @Override
        public AccountDto createAccount(AccountDto accountDto) {
            Account account=AccountMapper.mapToAccount(accountDto);
            Account savedAccount=accountRepository.save(account);
            return AccountMapper.mapToAccountDto(savedAccount);
            
        }
    
        @Override
        public AccountDto getAccountById(Long id) {
            Account account = accountRepository.findById(id).orElseThrow(() -> new AccountException("Account Does not exist"));
            return AccountMapper.mapToAccountDto(account);
        }
        //deposit///////////////////////////////////////////////////////////////////////
        @Override
        public AccountDto deposit(Long id, double amount) {
            Account account = accountRepository.findById(id).orElseThrow(() -> new AccountException("Account Does not exist"));
            double total = account.getBalance() + amount; ////
            account.setBalance(total);
            Account savedAccount = accountRepository.save(account);
    
            Transaction transaction = new Transaction();
            transaction.setAccountId(account.getId());
            transaction.setAmount(amount);
            transaction.setTransactionType(TRANSACTION_TYPE_DEPOSIT);
            transaction.setTimeStamp(LocalDateTime.now());
            
            transactionRepository.save(transaction);
            return AccountMapper.mapToAccountDto(savedAccount);
        }
        //withdraw/////////////////////////////////////////////////////////////////////////
        @Override
        public AccountDto withdraw(Long id, double amount) {
            Account account = accountRepository.findById(id).orElseThrow(() -> new AccountException("Account Does not exist"));
            if(account.getBalance() < amount)
            {
                throw new RuntimeException("Insufficient amount");
            }
            double total = account.getBalance() - amount; ////
            account.setBalance(total);
            Account savedAccount = accountRepository.save(account);

            Transaction transaction = new Transaction();
            transaction.setAccountId(id);
            transaction.setAmount(amount);
            transaction.setTransactionType(TRANSACTION_TYPE_WITHDRAW);
            transaction.setTimeStamp(LocalDateTime.now());

            transactionRepository.save(transaction);
            return AccountMapper.mapToAccountDto(savedAccount);

    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountException("Account Does not exist"));
        accountRepository.deleteById(id);
        System.out.println("Deleted account: " + account.getAccountHolderName() + " with balance: " + account.getBalance());

    }

    @Override
    public void transferFunds(TransferFundDto transferFundDto) {
        //retrive sender account amount 
        Account fromAccount = accountRepository.findById(transferFundDto.fromAccountId()).orElseThrow(() -> new AccountException("Account Does not exist"));
        //retrive receiver account amount
        Account toAccount = accountRepository.findById(transferFundDto.toAccountId()).orElseThrow(() -> new AccountException("Account Does not exist"));

        //Debit the amount from senderAccount Object
        fromAccount.setBalance(fromAccount.getBalance() - transferFundDto.amount());
        //credit the amount to receiverAccount Object
        toAccount.setBalance(toAccount.getBalance() + transferFundDto.amount());

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
}