package edu.miu.cs.cs425bank.cs425bank.customer.controller;

import edu.miu.cs.cs425bank.cs425bank.customer.dto.CustomerRequest;
import edu.miu.cs.cs425bank.cs425bank.customer.dto.CustomerResponse;
import edu.miu.cs.cs425bank.cs425bank.customer.mapper.CustomerMapper;
import edu.miu.cs.cs425bank.cs425bank.customer.model.Customer;
import edu.miu.cs.cs425bank.cs425bank.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cs425Bank/api/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }


    @PostMapping
    private ResponseEntity<CustomerResponse> createCustomer(@Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.mapToDomain(customerRequest);
        Customer newCustomer= customerService.createCustomer(customer);
        CustomerResponse customerResponse = customerMapper.mapToResponse(newCustomer);
        return ResponseEntity.ok(customerResponse);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable(name = "customerId") String customerId) {
        try {
            Customer newCustomer = customerService.getCustomerById(customerId);
            if (newCustomer == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
            }
            return ResponseEntity.ok(customerMapper.mapToResponse(newCustomer));
        }catch (NoSuchElementException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
        }
    }
}
