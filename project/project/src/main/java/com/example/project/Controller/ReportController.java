package com.example.project.Controller;

import com.example.project.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    ReportService reportService;

    @GetMapping("/dashboard")
    public ResponseEntity<?> getReport() {

        return new ResponseEntity<>(
                reportService.getReport(),
                HttpStatus.OK
        );
    }
}