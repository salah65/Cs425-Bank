package edu.miu.cs.cs425bank.cs425bank.customer.dto;

import edu.miu.cs.cs425bank.cs425bank.account.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CustomerResponse {
    String customerId;
    String firstName;
    String lastName;
    String telephoneNumber;
    List<Account> accounts;
}
