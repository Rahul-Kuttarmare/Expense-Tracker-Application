package com.gr.expenseTracker.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Table(name = "memberinfo")
@Entity
public class MemberInfo implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name ="memberId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "username")
//	@NotEmpty(message = "member-name cannot be empty")
	private String userName;
	
	@Column
//	@NotEmpty(message = "password cannot be empty")
	private String password;
	
	@Column
//	@NotEmpty(message = "role cannot be empty")
	private String role;
	
	@Column
//	@NotEmpty(message = "address cannot be empty")
	private String address;
	
	@Column
//	@Min(value = 1, message = "age must be greater than 0")
//	@Max(value = 90, message = "age must be less than 90")
	private int age;
	
	@Column
//	@Min(value = 1, message="agencyId must be greater than 0")
	private int agencyId;
	
	public MemberInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MemberInfo(Integer id, String userName, String password, String role, String address,
			int age, int agencyId) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.address = address;
		this.age = age;
		this.agencyId = agencyId;
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getAgencyId() {
		return agencyId;
	}


	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}

	@Override
	public String toString() {
		return this.role;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}


	@Override
	public String getUsername() {
		return this.userName;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}

	}
