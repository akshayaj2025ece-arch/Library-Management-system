package com.example.project.Service;

import com.example.project.Entity.Book;
import com.example.project.Entity.Payment;
import com.example.project.Entity.PurchaseOrder;
import com.example.project.Entity.Transaction;
import com.example.project.Repository.BookRepo;
import com.example.project.Repository.PaymentRepo;
import com.example.project.Repository.PurchaseOrderRepo;
import com.example.project.Repository.StudentRepo;
import com.example.project.Repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    PurchaseOrderRepo purchaseOrderRepo;

    public Map<String, Object> getReport() {

        List<Book> books = bookRepo.findAll();
        List<Transaction> transactions = transactionRepo.findAll();
        List<Payment> payments = paymentRepo.findAll();
        List<PurchaseOrder> purchases = purchaseOrderRepo.findAll();

        int totalCopies = 0;
        int availableCopies = 0;
        double totalFine = 0;
        double collectedFine = 0;
        double purchaseAmount = 0;

        for (Book book : books) {
            totalCopies += book.getTotalCopies();
            availableCopies += book.getAvailableCopies();
        }

        for (Transaction transaction : transactions) {
            totalFine += transaction.getFineAmount();
        }

        for (Payment payment : payments) {
            collectedFine += payment.getAmount();
        }

        for (PurchaseOrder purchase : purchases) {
            purchaseAmount += purchase.getTotalAmount();
        }

        Map<String, Object> report = new HashMap<>();

        report.put("totalBooks", books.size());
        report.put("totalCopies", totalCopies);
        report.put("availableCopies", availableCopies);
        report.put("issuedCopies", totalCopies - availableCopies);
        report.put("totalStudents", studentRepo.count());
        report.put("totalTransactions", transactions.size());
        report.put("totalFine", totalFine);
        report.put("collectedFine", collectedFine);
        report.put("pendingFine",
                totalFine - collectedFine);
        report.put("purchaseAmount", purchaseAmount);

        return report;
    }
}