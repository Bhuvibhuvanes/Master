package com.Expensemanager.springboot.Expensetracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Expensemanager.springboot.Expensetracker.model.PaymentMode;
import com.Expensemanager.springboot.Expensetracker.service.PaymentService;


@RestController
@ControllerAdvice
@RequestMapping("/payments")
public class PaymentController {
	@Autowired
    PaymentService paymentModeService;

    @GetMapping
    public ResponseEntity<List<PaymentMode>> getPaymentModes() {
        List<PaymentMode> paymentModes = paymentModeService.getpaymentMode();
        return new ResponseEntity<>(paymentModes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMode> getPaymentModeById(@PathVariable("id") int id) {
        PaymentMode paymentMode = paymentModeService.getPaymentModeId(id);
        return new ResponseEntity<>(paymentMode, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PaymentMode> createOrUpdatePaymentMode(@RequestBody PaymentMode paymentMode) {
        PaymentMode updatedPaymentMode = paymentModeService.createOrUpdatePaymentMode(paymentMode);
        return new ResponseEntity<>(updatedPaymentMode, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentMode> updatePaymentMode(@RequestBody PaymentMode paymentMode,
                                                         @PathVariable("id") int id) {
//        paymentMode.setId(id);
        PaymentMode updatedPaymentMode = paymentModeService.createOrUpdatePaymentMode(paymentMode);
        return new ResponseEntity<>(updatedPaymentMode, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentMode(@PathVariable("id") int id) {
        paymentModeService.deletePaymentModeId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
