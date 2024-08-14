package edu.miu.cs.cs425bank.cs425bank.customer.mapper;

import edu.miu.cs.cs425bank.cs425bank.core.Mapper;
import edu.miu.cs.cs425bank.cs425bank.customer.dto.CustomerRequest;
import edu.miu.cs.cs425bank.cs425bank.customer.dto.CustomerResponse;
import edu.miu.cs.cs425bank.cs425bank.customer.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerMapper implements Mapper<Customer, CustomerRequest, CustomerResponse> {


    @Override
    public CustomerResponse mapToResponse(Customer customer) {
        return new CustomerResponse(
                customer.getCustomerId().toString(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getTelephoneNumber(),
                customer.getAccounts());
    }

    @Override
    public Customer mapToDomain(CustomerRequest customerRequest) {
        return new Customer(customerRequest.getFirstName(), customerRequest.getLastName(), customerRequest.getTelephoneNumber());
    }

    @Override
    public List<CustomerResponse> mapToResponses(List<Customer> customers) {
        return customers.stream().map((customer -> new CustomerResponse(customer.getCustomerId().toString(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getTelephoneNumber(),
                customer.getAccounts()))).toList();
    }
}
