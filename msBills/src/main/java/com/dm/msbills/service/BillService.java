package com.dm.msbills.service;

import com.dm.msbills.models.Bill;
import com.dm.msbills.repositories.BillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

  private final BillRepository repository;

  public List<Bill> getAllBill() {
    return repository.findAll();
  }

  public Bill saveBill(Bill bill) {
    return repository.save(bill);
  }

  public Bill findByCustomer(String customer) {
    return repository.findByCustomerBill(customer).orElse(null);
  }

}
