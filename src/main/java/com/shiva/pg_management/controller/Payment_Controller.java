package com.shiva.pg_management.controller;

import com.shiva.pg_management.entity.Payment;
import com.shiva.pg_management.service.Payment_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class Payment_Controller {

    @Autowired
    private Payment_Service paymentService;

    @PostMapping("/add")
    public ResponseEntity<Payment> addPayment(
            @RequestBody Payment payment) {

        return ResponseEntity.ok(
                paymentService.addPayment(payment)
        );
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Payment>> getAllPayments() {

        return ResponseEntity.ok(
                paymentService.getAllPayments()
        );
    }

    @GetMapping("/get/{paymentId}")
    public ResponseEntity<Payment> getPaymentById(
            @PathVariable Integer paymentId) {

        return ResponseEntity.ok(
                paymentService.getPaymentById(paymentId)
        );
    }

    @PutMapping("/update/{paymentId}")
    public ResponseEntity<Payment> updatePayment(
            @PathVariable Integer paymentId,
            @RequestBody Payment payment) {

        return ResponseEntity.ok(
                paymentService.updatePayment(paymentId, payment)
        );
    }

    @DeleteMapping("/delete/{paymentId}")
    public ResponseEntity<String> deletePayment(
            @PathVariable Integer paymentId) {

        return ResponseEntity.ok(
                paymentService.deletePayment(paymentId)
        );
    }
}