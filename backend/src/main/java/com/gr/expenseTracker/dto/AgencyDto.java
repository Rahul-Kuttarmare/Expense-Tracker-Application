package com.gr.expenseTracker.dto;

public class AgencyDto {
	
	private int id;
	private String agencyName;
	public AgencyDto(int id, String agencyName) {
		super();
		this.id = id;
		this.agencyName = agencyName;
	}
	
	public AgencyDto() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}	
}
