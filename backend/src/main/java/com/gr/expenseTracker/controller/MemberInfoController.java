package com.gr.expenseTracker.controller;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gr.expenseTracker.dto.AddMemberDto;
import com.gr.expenseTracker.model.MemberInfo;
import com.gr.expenseTracker.service.MemberInfoService;

@RestController
@RequestMapping("/api/v2")
public class MemberInfoController {

	@Autowired
	MemberInfoService mService;
	
	@PostMapping("/member")
//	@RolesAllowed("ROLE_ADMIN")
	public MemberInfo createMember(@Valid @RequestBody AddMemberDto memberDto) {
		return mService.createMember(memberDto);
	}
	
	@GetMapping("/member/{agencyId}")
	@RolesAllowed("ROLE_ADMIN")
	public List<MemberInfo> getMember(@Valid @PathVariable Integer agencyId){
		return mService.getAllMembers(agencyId);
	}
}
