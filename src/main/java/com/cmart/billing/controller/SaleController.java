package com.cmart.billing.controller;
import com.cmart.billing.dto.*;
import com.cmart.billing.service.SaleService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/sales")
public class SaleController {
  private final SaleService service;
  public SaleController(SaleService service){this.service=service;}
  @PostMapping("/create")
  public ResponseEntity<SaleResponse> create(@Valid @RequestBody SaleRequest request) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
  }
}
