package com.cmart.billing.repository;
import com.cmart.billing.entity.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {
  List<SaleDetail> findByBillNumberOrderById(Long billNumber);
}
