package com.cmart.billing.controller;
import com.cmart.billing.entity.Product;
import com.cmart.billing.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/products")
public class ProductController {
  private final ProductRepository products;
  public ProductController(ProductRepository products){this.products=products;}
  @GetMapping("/{id}")
  public ResponseEntity<Product> get(@PathVariable Long id) {
    return products.findById(id).filter(Product::isActive)
      .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }
}
