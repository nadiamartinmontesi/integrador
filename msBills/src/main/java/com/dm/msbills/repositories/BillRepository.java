package com.dm.msbills.repositories;

import com.dm.msbills.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, String> {

  List<Bill> findByCustomerBill(String customer);
}
