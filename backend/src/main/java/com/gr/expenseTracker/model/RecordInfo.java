package com.gr.expenseTracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Table(name = "recordinfo")
@Entity
public class RecordInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer recordId;
	
	@Column
	@Min(value = 1, message="amount must be greater than 0")
	private int amount;
	
	@Column
	@NotBlank(message="description cannot be blank")
	private String description;
	
	@Column
	@NotBlank(message = " transaction type cannot be blank")
	private String transactionType;
	
	@Column
	@Min(value = 1,message="memberId must be greater than 1")
	private int memberId;
	
	@Column
	@Min(value = 1, message="agencyId must be greater than 1")
	private int agencyId;

	public RecordInfo(Integer recordId, int amount, String description, String transactionType, int memberId, int agencyId) {
		super();
		this.recordId = recordId;
		this.amount = amount;
		this.description = description;
		this.transactionType = transactionType;
		this.memberId = memberId;
		this.agencyId = agencyId;
	}

	public RecordInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
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
