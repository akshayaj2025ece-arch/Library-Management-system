package com.example.project.Service;

import com.example.project.Component.FineCalculator;
import com.example.project.Entity.Book;
import com.example.project.Entity.Transaction;
import com.example.project.Repository.BookRepo;
import com.example.project.Repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    BookRepo bookRepo;

    @Autowired
    FineCalculator fineCalculator;

    public Transaction borrowBook(Transaction transaction) {

        Book book = bookRepo.findById(transaction.getBookId()).orElse(null);

        if (book == null) {
            return null;
        }

        if (book.getAvailableCopies() <= 0) {
            return null;
        }

        transaction.setIssueDate(LocalDate.now());
        transaction.setDueDate(LocalDate.now().plusDays(14));
        transaction.setStatus("Issued");
        transaction.setFineAmount(0);

        book.setAvailableCopies(book.getAvailableCopies() - 1);

        bookRepo.save(book);

        return transactionRepo.save(transaction);
    }

    public Transaction returnBook(int id) {

        Transaction transaction =
                transactionRepo.findById(id).orElse(null);

        if (transaction == null) {
            return null;
        }

        LocalDate returnDate = LocalDate.now();

        transaction.setReturnDate(returnDate);

        long overdueDays = ChronoUnit.DAYS.between(
                transaction.getDueDate(),
                returnDate
        );

        if (overdueDays < 0) {
            overdueDays = 0;
        }

        int fine = fineCalculator.calculateFine((int) overdueDays);

        transaction.setFineAmount(fine);
        transaction.setStatus("Returned");

        Book book =
                bookRepo.findById(transaction.getBookId()).orElse(null);

        if (book != null) {
            book.setAvailableCopies(
                    book.getAvailableCopies() + 1
            );

            bookRepo.save(book);
        }

        return transactionRepo.save(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactionRepo.findAll();
    }

    public Transaction getTransaction(int id) {
        return transactionRepo.findById(id).orElse(null);
    }

    public String deleteTransaction(int id) {
        transactionRepo.deleteById(id);
        return "Transaction deleted successfully";
    }
}