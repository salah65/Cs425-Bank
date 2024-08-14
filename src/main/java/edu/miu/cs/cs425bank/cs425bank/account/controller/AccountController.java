package edu.miu.cs.cs425bank.cs425bank.account.controller;

import edu.miu.cs.cs425bank.cs425bank.account.dto.AccountRequest;
import edu.miu.cs.cs425bank.cs425bank.account.dto.AccountResponse;
import edu.miu.cs.cs425bank.cs425bank.account.mapper.AccountMapper;
import edu.miu.cs.cs425bank.cs425bank.account.model.Account;
import edu.miu.cs.cs425bank.cs425bank.account.service.AccountService;
import edu.miu.cs.cs425bank.cs425bank.customer.model.Customer;
import edu.miu.cs.cs425bank.cs425bank.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cs425Bank/api/accounts")
public class AccountController {
    private final AccountService accountService;
    private final AccountMapper accountMapper;
    private final CustomerService customerService;

    public AccountController(AccountService accountService, CustomerService customerService, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountMapper = accountMapper;
        this.customerService = customerService;
    }

    @PostMapping
    private ResponseEntity<?> createAccount(@Valid  @RequestBody AccountRequest accountRequest) {
        try {
            Customer customer = customerService.getCustomerById(accountRequest.getCustomerId());
            Account account = accountMapper.mapToDomain(accountRequest);
            account.setCustomer(customer);
            Account newAccount = accountService.createAccount(account);
            AccountResponse accountResponse = accountMapper.mapToResponse(newAccount);
            return ResponseEntity.ok(accountResponse);
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body("Customer not found");
        }

    }

    @GetMapping
    private ResponseEntity<List<AccountResponse>> getAllPlatinumAccounts() {
        List<AccountResponse> accountResponse=accountMapper.mapToResponses(accountService.getAllPlatinumAccounts());
        return ResponseEntity.ok(accountResponse);
    }
}
