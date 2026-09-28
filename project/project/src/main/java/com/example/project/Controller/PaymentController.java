package com.example.project.Controller;

import com.example.project.Entity.Payment;
import com.example.project.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<?> createPayment(
            @RequestBody Payment payment) {

        return new ResponseEntity<>(
                paymentService.createPayment(payment),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/")
    public ResponseEntity<?> getPayments() {

        return new ResponseEntity<>(
                paymentService.getPayments(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPayment(
            @PathVariable int id) {

        return new ResponseEntity<>(
                paymentService.getPayment(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/update")
    public ResponseEntity<?> updatePayment(
            @RequestBody Payment payment) {

        return new ResponseEntity<>(
                paymentService.updatePayment(payment),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePayment(
            @PathVariable int id) {

        return new ResponseEntity<>(
                paymentService.deletePayment(id),
                HttpStatus.OK
        );
    }
}