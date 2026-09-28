package com.example.project.Component;

import org.springframework.stereotype.Component;

@Component
public class FineCalculator {

    public int calculateFine(int overdueDays) {

        int finePerDay = 2;

        return overdueDays * finePerDay;
    }
}