package com.example.project.Service;

import com.example.project.Entity.Payment;
import com.example.project.Entity.Transaction;
import com.example.project.Repository.PaymentRepo;
import com.example.project.Repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    TransactionRepo transactionRepo;

    public Payment createPayment(Payment payment) {

        Transaction transaction =
                transactionRepo.findById(
                        payment.getTransactionId()
                ).orElse(null);

        if (transaction == null) {
            return null;
        }

        if (payment.getAmount() <= 0) {
            return null;
        }

        payment.setPaymentDate(LocalDate.now());

        return paymentRepo.save(payment);
    }

    public List<Payment> getPayments() {
        return paymentRepo.findAll();
    }

    public Payment getPayment(int id) {
        return paymentRepo.findById(id).orElse(null);
    }

    public Payment updatePayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    public String deletePayment(int id) {
        paymentRepo.deleteById(id);
        return "Payment deleted successfully";
    }
}