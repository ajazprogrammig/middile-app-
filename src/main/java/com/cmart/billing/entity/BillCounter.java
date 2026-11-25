package com.cmart.billing.entity;
import jakarta.persistence.*;
@Entity @Table(name="bill_counter")
public class BillCounter {
  @Id private Integer id;
  @Column(name="last_bill_number", nullable=false) private Long lastBillNumber;
  public Integer getId(){return id;} public void setId(Integer v){id=v;}
  public Long getLastBillNumber(){return lastBillNumber;} public void setLastBillNumber(Long v){lastBillNumber=v;}
}
