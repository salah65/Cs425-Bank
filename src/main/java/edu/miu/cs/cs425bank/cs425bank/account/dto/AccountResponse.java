package edu.miu.cs.cs425bank.cs425bank.account.dto;

import edu.miu.cs.cs425bank.cs425bank.customer.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountResponse {
    String accountNumber;

    String dateOpened;

    String status;

    String balance;

    Customer customer;
}
