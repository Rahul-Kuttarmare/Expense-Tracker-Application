package com.gr.expenseTracker.dto;

public class AddMemberDto {
	
	private int agencyId;
	private String userName;
	private String Address;
	private int age;
	private String role;
	private String password;
	public AddMemberDto(int agencyId, String userName, String address, int age, String role, String password) {
		super();
		this.agencyId = agencyId;
		this.userName = userName;
		Address = address;
		this.age = age;
		this.role = role;
		this.password = password;
	}
	public AddMemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
}
