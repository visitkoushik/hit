package com.teahouse.inventory.teahouseinventory.services;

import java.util.Date;
import java.util.List;

import com.teahouse.inventory.teahouseinventory.domain.Billing;

public interface BillingService extends BaseService<Billing,String>{
    
    List<Billing> findByDateRange(Date startDate,Date endDate);
    List<Billing> findByEmployee(String empID);
    
}
