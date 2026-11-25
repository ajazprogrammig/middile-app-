package com.cmart.billing.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity @Table(name="sale_details")
public class SaleDetail {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @Column(name="bill_number", nullable=false) private Long billNumber;
  @Column(name="product_id", nullable=false) private Long productId;
  @Column(name="product_name", nullable=false) private String productName;
  @Column(nullable=false, precision=12, scale=2) private BigDecimal mrp;
  @Column(name="sale_price", nullable=false, precision=12, scale=2) private BigDecimal salePrice;
  @Column(nullable=false) private Integer quantity;
  @Column(name="line_total", nullable=false, precision=12, scale=2) private BigDecimal lineTotal;
  public void setBillNumber(Long v){billNumber=v;} public void setProductId(Long v){productId=v;}
  public void setProductName(String v){productName=v;} public void setMrp(BigDecimal v){mrp=v;}
  public void setSalePrice(BigDecimal v){salePrice=v;} public void setQuantity(Integer v){quantity=v;}
  public void setLineTotal(BigDecimal v){lineTotal=v;}
}
