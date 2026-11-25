package com.cmart.billing.service;
import com.cmart.billing.dto.*;
import com.cmart.billing.entity.*;
import com.cmart.billing.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class SaleService {
  private final BillCounterRepository counters;
  private final ProductRepository products;
  private final SaleRepository sales;
  private final SaleDetailRepository details;

  public SaleService(BillCounterRepository counters, ProductRepository products,
                     SaleRepository sales, SaleDetailRepository details) {
    this.counters=counters; this.products=products; this.sales=sales; this.details=details;
  }

  @Transactional
  public SaleResponse create(SaleRequest request) {
    BillCounter counter = counters.findLocked(1)
      .orElseThrow(() -> new IllegalStateException("bill_counter row id=1 is missing; run schema.sql"));
    long billNo = counter.getLastBillNumber() + 1L;
    BigDecimal total = BigDecimal.ZERO;
    List<SaleResponse.Line> responseLines = new ArrayList<>();
    List<SaleDetail> rows = new ArrayList<>();

    for (SaleRequest.SaleLineRequest input : request.getItems()) {
      Product p = products.findById(input.getProductId())
        .filter(Product::isActive)
        .orElseThrow(() -> new IllegalArgumentException("Product not found/inactive: " + input.getProductId()));
      BigDecimal lineTotal = p.getSalePrice().multiply(BigDecimal.valueOf(input.getQuantity()))
        .setScale(2, java.math.RoundingMode.HALF_UP);
      total = total.add(lineTotal);
      SaleDetail d = new SaleDetail();
      d.setBillNumber(billNo); d.setProductId(p.getProductId());
      d.setProductName(p.getProductName()); d.setMrp(p.getMrp());
      d.setSalePrice(p.getSalePrice()); d.setQuantity(input.getQuantity());
      d.setLineTotal(lineTotal); rows.add(d);
      responseLines.add(new SaleResponse.Line(p.getProductId(), p.getProductName(),
        p.getMrp(), p.getSalePrice(), input.getQuantity(), lineTotal));
    }

    Sale sale = new Sale();
    sale.setBillNumber(billNo); sale.setBillDate(LocalDateTime.now());
    sale.setTotalAmount(total);
    sales.save(sale);
    details.saveAll(rows);
    counter.setLastBillNumber(billNo);
    counters.save(counter);
    return new SaleResponse(billNo, sale.getBillDate(), total, responseLines);
  }
}
