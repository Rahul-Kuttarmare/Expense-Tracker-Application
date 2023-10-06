package com.gr.expenseTracker.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddRecordDto {
	
	
	@Min(value = 0, message="amount must be greter than 0")
	private int amount;

	@NotNull(message = "description is mandatory")
	private String description;

	@NotEmpty(message = "transaction type cannot be empty")
	private String transactionType;

	@Min(value = 1, message="memberId must be greater than 0")
	private int memberId;
	
	@Min(value = 1, message="agencyId must be greater than 0")
	private int agencyId;
	

	public AddRecordDto(int amount, String description, String transactionType, int memberId, int agencyId) {
		super();
		this.amount = amount;
		this.description = description;
		this.transactionType = transactionType;
		this.memberId = memberId;
		this.agencyId = agencyId;
	}

	public AddRecordDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
}
