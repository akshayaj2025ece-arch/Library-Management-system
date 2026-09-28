package com.example.project.Controller;

import com.example.project.Entity.PurchaseOrder;
import com.example.project.Service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping("/create")
    public ResponseEntity<?> createPurchase(
            @RequestBody PurchaseOrder purchaseOrder) {

        return new ResponseEntity<>(
                purchaseService.createPurchase(purchaseOrder),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/")
    public ResponseEntity<?> getPurchases() {

        return new ResponseEntity<>(
                purchaseService.getPurchases(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPurchase(
            @PathVariable int id) {

        return new ResponseEntity<>(
                purchaseService.getPurchase(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePurchase(
            @RequestBody PurchaseOrder purchaseOrder) {

        return new ResponseEntity<>(
                purchaseService.updatePurchase(purchaseOrder),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePurchase(
            @PathVariable int id) {

        return new ResponseEntity<>(
                purchaseService.deletePurchase(id),
                HttpStatus.OK
        );
    }
}