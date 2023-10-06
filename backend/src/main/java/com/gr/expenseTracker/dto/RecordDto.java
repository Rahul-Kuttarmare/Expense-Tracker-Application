package com.gr.expenseTracker.dto;

public class RecordDto {

	private int amount;

	private String description;

	private String transactionType;
	
	private String memberName;

	public RecordDto(int amount, String description, String transactionType, String memberName) {
		super();
		this.amount = amount;
		this.description = description;
		this.transactionType = transactionType;
		this.memberName = memberName;
	}

	public RecordDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
}
