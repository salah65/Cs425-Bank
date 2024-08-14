package edu.miu.cs.cs425bank.cs425bank.customer.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import edu.miu.cs.cs425bank.cs425bank.account.model.Account;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long customerId;

    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    @NotBlank
    String telephoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    @JsonManagedReference
    List<Account> accounts;

    public Customer(String firstName, String lastName, String telephoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.accounts = List.of(new Account(this));
    }
}
