package com.cmart.billing.repository;
import com.cmart.billing.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SaleRepository extends JpaRepository<Sale, Long> {}
