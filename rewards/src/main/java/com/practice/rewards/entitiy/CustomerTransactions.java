package com.practice.rewards.entitiy;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerTransactions {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private long txnId;
	private int customerId;
	private LocalDate txnDate;
	private float txnAmount;
	
	public CustomerTransactions() {
		super();
	}

	public CustomerTransactions(long txnId, int customerId, LocalDate txnDate, float txnAmount) {
		super();
		this.txnId = txnId;
		this.customerId = customerId;
		this.txnDate = txnDate;
		this.txnAmount = txnAmount;
	}

	public long getTxnId() {
		return txnId;
	}

	public void setTxnId(long txnId) {
		this.txnId = txnId;
	}

	public int getcustomerId() {
		return customerId;
	}

	public void setcustomerId(int customerId) {
		this.customerId = customerId;
	}

	public LocalDate getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(LocalDate txnDate) {
		this.txnDate = txnDate;
	}

	public float getTxnAmount() {
		return txnAmount;
	}

	public void setTxnAmount(float txnAmount) {
		this.txnAmount = txnAmount;
	}
	
}
