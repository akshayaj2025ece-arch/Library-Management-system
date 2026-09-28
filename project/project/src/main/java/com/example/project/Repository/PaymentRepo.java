package com.example.project.Repository;

import com.example.project.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment , Integer> {
}
