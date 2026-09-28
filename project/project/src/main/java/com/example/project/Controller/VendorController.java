package com.example.project.Controller;

import com.example.project.Entity.Vendor;
import com.example.project.Service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    @Autowired
    VendorService vendorService;

    @PostMapping("/create")
    public ResponseEntity<?> createVendor(
            @RequestBody Vendor vendor) {

        return new ResponseEntity<>(
                vendorService.createVendor(vendor),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/")
    public ResponseEntity<?> getVendors() {

        return new ResponseEntity<>(
                vendorService.getVendors(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVendor(
            @PathVariable int id) {

        return new ResponseEntity<>(
                vendorService.getVendor(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateVendor(
            @RequestBody Vendor vendor) {

        return new ResponseEntity<>(
                vendorService.updateVendor(vendor),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVendor(
            @PathVariable int id) {

        return new ResponseEntity<>(
                vendorService.deleteVendor(id),
                HttpStatus.OK
        );
    }
}