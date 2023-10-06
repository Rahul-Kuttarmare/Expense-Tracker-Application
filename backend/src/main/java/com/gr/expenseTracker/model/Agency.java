package com.gr.expenseTracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Table(name = "agency")
@Entity
public class Agency {
	
	@Id
	@Column(name = "agencyId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "agency_name")
	@NotEmpty(message="Agency Name cannot be empty")
	private String agencyName;
	
	@Column
	@NotEmpty(message = "Description cannot be Empty")
	private String description;

	public Agency() {
		super();
	}

	public Agency(Integer id, String agencyName, String description) {
		super();
		this.id = id;
		this.agencyName = agencyName;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	}
