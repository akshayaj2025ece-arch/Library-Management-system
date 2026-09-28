package com.example.project.Service;

import com.example.project.Entity.Book;
import com.example.project.Entity.PurchaseOrder;
import com.example.project.Repository.BookRepo;
import com.example.project.Repository.PurchaseOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    PurchaseOrderRepo purchaseOrderRepo;

    @Autowired
    BookRepo bookRepo;

    public PurchaseOrder createPurchase(PurchaseOrder purchaseOrder) {

        Book book =
                bookRepo.findById(purchaseOrder.getBookId()).orElse(null);

        if (book == null) {
            return null;
        }

        double total =
                purchaseOrder.getQuantity()
                        * purchaseOrder.getUnitPrice();

        purchaseOrder.setTotalAmount(total);
        purchaseOrder.setPurchaseDate(LocalDate.now());
        purchaseOrder.setStatus("Purchased");

        book.setTotalCopies(
                book.getTotalCopies()
                        + purchaseOrder.getQuantity()
        );

        book.setAvailableCopies(
                book.getAvailableCopies()
                        + purchaseOrder.getQuantity()
        );

        bookRepo.save(book);

        return purchaseOrderRepo.save(purchaseOrder);
    }

    public List<PurchaseOrder> getPurchases() {
        return purchaseOrderRepo.findAll();
    }

    public PurchaseOrder getPurchase(int id) {
        return purchaseOrderRepo.findById(id).orElse(null);
    }

    public PurchaseOrder updatePurchase(
            PurchaseOrder purchaseOrder) {

        return purchaseOrderRepo.save(purchaseOrder);
    }

    public String deletePurchase(int id) {
        purchaseOrderRepo.deleteById(id);
        return "Purchase order deleted successfully";
    }
}