package com.Expensemanager.springboot.Expensetracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Expensemanager.springboot.Expensetracker.model.ExpenseManagerNotFoundException;
import com.Expensemanager.springboot.Expensetracker.model.PaymentMode;
import com.Expensemanager.springboot.Expensetracker.repository.PaymentmodeRepository;
@Service
public class PaymentService {
	@Autowired
	PaymentmodeRepository paymentModeRepository;

	public List<PaymentMode> getpaymentMode() {
		List<PaymentMode> pay = paymentModeRepository.findAll();
		if (pay.size() > 0) {
			return pay;
		} else {
			return new ArrayList<PaymentMode>();
		}

	}

	public PaymentMode createOrUpdatePaymentMode(PaymentMode paymentMode) {
		Optional<PaymentMode> pay = paymentModeRepository.findById(paymentMode.getId());
		if (pay.isPresent()) {
			PaymentMode pays = new PaymentMode();
			pays.getId();
			pays.getInitial_amount();
			pays.getMode();
			paymentModeRepository.save(pays);
			return paymentMode;

		} else {
			paymentMode = paymentModeRepository.save(paymentMode);
			return paymentMode;
		}
	}

	public PaymentMode updatePaymentMode(PaymentMode paymentMode, int id) {
		Optional<PaymentMode> pays = paymentModeRepository.findById(id);
		if (pays.isPresent()) {
			PaymentMode newPay = new PaymentMode();
			newPay.getInitial_amount();
			newPay.getMode();
			paymentModeRepository.save(newPay);
			return paymentMode;
		} else {
			throw new ExpenseManagerNotFoundException("No record Exist");
		}
	}

	public void deletePaymentModeId(int id) {
		Optional<PaymentMode> pays = paymentModeRepository.findById(id);
		if (pays.isPresent()) {
			paymentModeRepository.deleteById(id);
		} else {
			throw new ExpenseManagerNotFoundException("No record Exist");
		}

	}

	public PaymentMode getPaymentModeId(int id) {
		Optional<PaymentMode> pay = paymentModeRepository.findById(id);
		if (pay.isPresent()) {
			return pay.get();
		} else {
			throw new ExpenseManagerNotFoundException("No record Exist");
		}
	}

}
