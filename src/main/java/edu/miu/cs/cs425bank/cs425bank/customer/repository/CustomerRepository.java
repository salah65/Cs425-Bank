package edu.miu.cs.cs425bank.cs425bank.customer.repository;

import edu.miu.cs.cs425bank.cs425bank.account.model.Account;
import edu.miu.cs.cs425bank.cs425bank.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
