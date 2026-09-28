package com.example.project.Repository;

import com.example.project.Entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepo extends JpaRepository<PurchaseOrder , Integer> {
}
