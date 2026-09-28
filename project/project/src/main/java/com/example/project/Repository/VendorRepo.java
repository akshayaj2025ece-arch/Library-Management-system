package com.example.project.Repository;

import com.example.project.Entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepo extends JpaRepository<Vendor , Integer> {

}
