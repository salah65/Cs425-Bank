package edu.miu.cs.cs425bank.cs425bank.account.repository;

import edu.miu.cs.cs425bank.cs425bank.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {
    @Query("SELECT a FROM Account a WHERE a.status = :status AND a.dateOpened <= :cutoffDate")
    List<Account> findAllByStatusAndDateOpenedBefore(@Param("status") String status, @Param("cutoffDate") Date cutoffDate);

}
