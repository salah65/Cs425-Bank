package edu.miu.cs.cs425bank.cs425bank.account.service;


import edu.miu.cs.cs425bank.cs425bank.account.model.Account;

import java.util.List;

public interface AccountService {
    Account createAccount(Account account);
    List<Account> getAllPlatinumAccounts();
}
