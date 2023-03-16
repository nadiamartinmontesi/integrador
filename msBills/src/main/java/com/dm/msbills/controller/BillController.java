package com.dm.msbills.controller;

import com.dm.msbills.models.Bill;
import com.dm.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

  private final BillService service;

  @GetMapping("/all")
  @PreAuthorize("hasAuthority('GROUP_provider')")
  public ResponseEntity<List<Bill>> getAll() {
    return ResponseEntity.ok().body(service.getAllBill());
  }


  @PostMapping()
  @PreAuthorize("hasAuthority('GROUP_provider')")
  public ResponseEntity<Bill> saveBill(@RequestBody Bill bill) {
    return ResponseEntity.ok().body(service.saveBill(bill));
  }

  @GetMapping("/findBy")
  @PreAuthorize("hasAuthority('GROUP_provider')")
  public ResponseEntity<Bill> findByCustomer(@RequestParam String customer) {
    Bill bill = service.findByCustomer(customer);
    if (bill != null) {
      return ResponseEntity.ok().body(bill);
    }
    return ResponseEntity.notFound().build();
  }


}
