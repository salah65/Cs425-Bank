package edu.miu.cs.cs425bank.cs425bank.account.service;

import edu.miu.cs.cs425bank.cs425bank.account.model.Account;
import edu.miu.cs.cs425bank.cs425bank.account.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllPlatinumAccounts() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -5); // Subtract 5 years
        Date fiveYearsAgo = calendar.getTime();

        return accountRepository.findAllByStatusAndDateOpenedBefore("Active", fiveYearsAgo).stream()
                .sorted(Comparator.comparing(Account::getBalance).reversed())
                .toList();
    }


}
