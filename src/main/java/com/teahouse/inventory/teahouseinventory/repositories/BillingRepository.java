package com.teahouse.inventory.teahouseinventory.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teahouse.inventory.teahouseinventory.domain.Billing;

@Repository
public interface BillingRepository extends JpaRepository<Billing,Long>{


    @Query("SELECT b FROM billings b WHERE b.billingDate BETWEEN :startDate AND :endDate")
    List<Billing> findByDateRange(@Param("startDate") Date startDate,@Param("endDate") Date endDate);
    @Query("SELECT b FROM billings b WHERE b.employee = :employee_id")
    List<Billing> findByEmployee(@Param("employee_id") Long empID);
}
