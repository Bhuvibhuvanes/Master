package com.Expensemanager.springboot.Expensetracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class PaymentMode {
		@Id
		private int id;
		private double Initial_amount;
		
		private String mode;

		public PaymentMode(int id, double Initial_amount, String mode) {
			super();
			this.id = id;
			this.mode = mode;
			this.Initial_amount = Initial_amount;
		}
		public PaymentMode() {
			super();
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getMode() {
			return mode;
		}

		public void setMode(String mode) {
			this.mode = mode;
		}

		public double getInitial_amount() {
			return Initial_amount;
		}

		public void setInitial_amount(double initial_amount) {
			Initial_amount = initial_amount;
		}


}
