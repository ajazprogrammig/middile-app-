package com.cmart.billing.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity @Table(name="product_master")
public class Product {
  @Id @Column(name="product_id") private Long productId;
  @Column(name="product_name", nullable=false) private String productName;
  @Column(nullable=false, precision=12, scale=2) private BigDecimal mrp;
  @Column(name="sale_price", nullable=false, precision=12, scale=2) private BigDecimal salePrice;
  private boolean active = true;
  public Long getProductId(){return productId;} public void setProductId(Long v){productId=v;}
  public String getProductName(){return productName;} public void setProductName(String v){productName=v;}
  public BigDecimal getMrp(){return mrp;} public void setMrp(BigDecimal v){mrp=v;}
  public BigDecimal getSalePrice(){return salePrice;} public void setSalePrice(BigDecimal v){salePrice=v;}
  public boolean isActive(){return active;} public void setActive(boolean v){active=v;}
}
