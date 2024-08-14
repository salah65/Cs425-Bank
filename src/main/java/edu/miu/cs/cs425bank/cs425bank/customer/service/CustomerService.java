package edu.miu.cs.cs425bank.cs425bank.customer.service;


import edu.miu.cs.cs425bank.cs425bank.customer.model.Customer;

public interface CustomerService {
    Customer createCustomer(Customer customer);

    Customer getCustomerById(String customerId);
}
