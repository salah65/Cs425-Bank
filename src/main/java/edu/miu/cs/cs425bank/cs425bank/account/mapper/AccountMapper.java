package edu.miu.cs.cs425bank.cs425bank.account.mapper;

import edu.miu.cs.cs425bank.cs425bank.account.dto.AccountRequest;
import edu.miu.cs.cs425bank.cs425bank.account.dto.AccountResponse;
import edu.miu.cs.cs425bank.cs425bank.account.model.Account;
import edu.miu.cs.cs425bank.cs425bank.core.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountMapper implements Mapper<Account, AccountRequest, AccountResponse> {
    @Override
    public AccountResponse mapToResponse(Account account) {
        return new AccountResponse(account.getAccountNumber(),
                account.getDateOpened().toString(),
                account.getStatus(), account.getBalance(),account.getCustomer());
    }

    @Override
    public Account mapToDomain(AccountRequest accountRequest) {
        return new Account();
    }

    @Override
    public List<AccountResponse> mapToResponses(List<Account> accounts) {
        return accounts.stream().map((account -> new AccountResponse(
                account.getAccountNumber(),
                account.getDateOpened().toString(),
                account.getStatus(), account.getBalance(),
                account.getCustomer()
        ))).toList();
    }
}
