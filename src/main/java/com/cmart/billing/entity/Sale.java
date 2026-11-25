package com.cmart.billing.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity @Table(name="sale")
public class Sale {
  @Id @Column(name="bill_number") private Long billNumber;
  @Column(name="bill_date", nullable=false) private LocalDateTime billDate;
  @Column(name="total_amount", nullable=false, precision=12, scale=2) private BigDecimal totalAmount;
  public Long getBillNumber(){return billNumber;} public void setBillNumber(Long v){billNumber=v;}
  public LocalDateTime getBillDate(){return billDate;} public void setBillDate(LocalDateTime v){billDate=v;}
  public BigDecimal getTotalAmount(){return totalAmount;} public void setTotalAmount(BigDecimal v){totalAmount=v;}
}
