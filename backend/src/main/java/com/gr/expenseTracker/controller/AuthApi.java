package com.gr.expenseTracker.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gr.expenseTracker.dto.AddMemberDto;
import com.gr.expenseTracker.dto.AuthRequest;
import com.gr.expenseTracker.dto.AuthResponse;
import com.gr.expenseTracker.exception.UserExistException;
import com.gr.expenseTracker.jwt.JwtTokenUtil;
import com.gr.expenseTracker.model.MemberInfo;
import com.gr.expenseTracker.repository.MemberInfoRepository;

@RestController
public class AuthApi {
	@Autowired 
	AuthenticationManager authManager;
	
	@Autowired 
	JwtTokenUtil jwtUtil;
	
	@Autowired
	MemberInfoRepository mRepo;
	
	@Autowired 
	PasswordEncoder encoder;
	
	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		
		Optional<MemberInfo> optional = mRepo.findByAgencyIdAndUserNameAndRole(request.getAgencyId(), request.getUserName(), request.getRole());
		if(optional.isEmpty()) { 
			throw new UserExistException("user does not exist");
		}
		try {
			Authentication authentication = authManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							request.getUserName(), request.getPassword())
			);
			MemberInfo info = optional.get();
			String str = info.getId().toString();
			MemberInfo user = (MemberInfo) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(user);
			System.out.println("generated token : "+accessToken);
			AuthResponse response = new AuthResponse(str, accessToken);
			return ResponseEntity.ok().body(response);
			
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	
	@PostMapping("/auth/adduser")
	public Map<String,String> addUser(@RequestBody AddMemberDto request) {
		
		Optional<MemberInfo> optional = mRepo.findByUserName(request.getUserName());
		
		if(!optional.isEmpty()) {
			throw new UserExistException("username already exist");
		}
		System.out.println(request.getUserName());
		System.out.println(request.getPassword());
		System.out.println(request.getRole());
		
		MemberInfo member = new MemberInfo();
		String password = encoder.encode(request.getPassword());
		member.setPassword(password);
		member.setUserName(request.getUserName());
		member.setAgencyId(request.getAgencyId());
		member.setAge(request.getAge());
		member.setAddress(request.getAddress());
		member.setRole(request.getRole());
		mRepo.save(member);
		Map<String,String> map = new HashMap<>();
		map.put("message", "add user data success");
		return map;
	}
}
