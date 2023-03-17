package com.dm.msbills.service;

import com.dm.msbills.models.Bill;
import com.dm.msbills.models.BillWithUser;
import com.dm.msbills.models.User;
import com.dm.msbills.repositories.BillRepository;
import com.dm.msbills.repositories.FeignUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BillService {

  private final BillRepository repository;
  private final FeignUserRepository feignUserRepository;

  public List<Bill> getAllBill() {
    return repository.findAll();
  }

  public Bill saveBill(Bill bill) {
    return repository.save(bill);
  }

  public List<BillWithUser> findAllByUsername(String username) {
    User user = feignUserRepository.findByUsername(username);
    List<Bill> billsByUser = repository.findByCustomerBill(username);
    List<BillWithUser> allBills = new ArrayList<>();

    for (Bill b : billsByUser){
      BillWithUser billWithUser = new BillWithUser(b.getIdBill(), b.getBillingDate(), b.getTotalPrice(), user);
      allBills.add(billWithUser);
    }
    return allBills;
  }

}
