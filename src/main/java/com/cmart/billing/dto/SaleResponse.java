package com.cmart.billing.dto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
public record SaleResponse(Long billNumber, LocalDateTime billDate,
                           BigDecimal totalAmount, List<Line> items) {
  public record Line(Long productId, String productName, BigDecimal mrp,
                     BigDecimal salePrice, Integer quantity, BigDecimal lineTotal) {}
}
