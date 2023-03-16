package com.dm.msbills.repositories;

import com.dm.msbills.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, String> {

  Optional<Bill> findByCustomerBill(String customer);
}
