package edu.miu.cs.cs425bank.cs425bank.account.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import edu.miu.cs.cs425bank.cs425bank.customer.model.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long accountId;

    @NotBlank()
    @Column(unique = true)
    String accountNumber;

    Date dateOpened;

    @NotBlank
    String status;

    @NotBlank
    String balance;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "customerId")
    @JsonBackReference
    Customer customer;

    @PrePersist
    public void generateAccountNumber() {
        if (this.accountNumber == null) {
            this.accountNumber = UUID.randomUUID().toString();
        }
        this.dateOpened = new Date();
        this.status = "Active";
        this.balance = "0";
    }

    public Account(Customer customer) {
        this.customer = customer;
    }
}
