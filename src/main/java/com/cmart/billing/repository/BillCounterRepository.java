package com.cmart.billing.repository;
import com.cmart.billing.entity.BillCounter;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
public interface BillCounterRepository extends JpaRepository<BillCounter, Integer> {
  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Query("select c from BillCounter c where c.id = :id")
  Optional<BillCounter> findLocked(@Param("id") Integer id);
}
