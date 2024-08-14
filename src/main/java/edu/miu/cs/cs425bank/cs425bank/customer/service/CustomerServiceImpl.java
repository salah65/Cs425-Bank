package edu.miu.cs.cs425bank.cs425bank.customer.service;

import edu.miu.cs.cs425bank.cs425bank.customer.model.Customer;
import edu.miu.cs.cs425bank.cs425bank.customer.repository.CustomerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(String customerId) throws NoSuchElementException {
        return customerRepository.findById(Long.parseLong(customerId)).orElseThrow();
    }
}
