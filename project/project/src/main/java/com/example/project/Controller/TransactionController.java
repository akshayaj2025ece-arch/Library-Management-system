package com.example.project.Controller;

import com.example.project.Entity.Transaction;
import com.example.project.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrow")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/")
    public ResponseEntity<?> borrowBook(
            @RequestBody Transaction transaction) {

        return new ResponseEntity<>(
                transactionService.borrowBook(transaction),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/")
    public ResponseEntity<?> getTransactions() {

        return new ResponseEntity<>(
                transactionService.getTransactions(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransaction(
            @PathVariable int id) {

        return new ResponseEntity<>(
                transactionService.getTransaction(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<?> returnBook(
            @PathVariable int id) {

        return new ResponseEntity<>(
                transactionService.returnBook(id),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransaction(
            @PathVariable int id) {

        return new ResponseEntity<>(
                transactionService.deleteTransaction(id),
                HttpStatus.OK
        );
    }
}