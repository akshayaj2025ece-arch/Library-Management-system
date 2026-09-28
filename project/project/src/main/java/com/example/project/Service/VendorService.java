package com.example.project.Service;

import com.example.project.Entity.Vendor;
import com.example.project.Repository.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {

    @Autowired
    VendorRepo vendorRepo;

    public Vendor createVendor(Vendor vendor) {
        return vendorRepo.save(vendor);
    }

    public List<Vendor> getVendors() {
        return vendorRepo.findAll();
    }

    public Vendor getVendor(int id) {
        return vendorRepo.findById(id).orElse(null);
    }

    public Vendor updateVendor(Vendor vendor) {
        return vendorRepo.save(vendor);
    }

    public String deleteVendor(int id) {
        vendorRepo.deleteById(id);
        return "Vendor deleted successfully";
    }
}