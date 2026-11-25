package com.cmart.billing.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
public class SaleRequest {
  @NotEmpty @Valid private List<SaleLineRequest> items;
  public List<SaleLineRequest> getItems(){return items;}
  public void setItems(List<SaleLineRequest> v){items=v;}
  public static class SaleLineRequest {
    @NotNull private Long productId;
    @NotNull @Min(1) @Max(9999) private Integer quantity;
    public Long getProductId(){return productId;} public void setProductId(Long v){productId=v;}
    public Integer getQuantity(){return quantity;} public void setQuantity(Integer v){quantity=v;}
  }
}
