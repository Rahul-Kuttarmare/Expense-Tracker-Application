package com.gr.expenseTracker.controller;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gr.expenseTracker.dto.TotalAmountDto;
import com.gr.expenseTracker.service.SummaryService;

@RestController
@RequestMapping("/api/summary")
public class SummaryController {
	
	@Autowired
	SummaryService sService;
	
	@GetMapping("/credit/{agencyId}")
	@RolesAllowed("ROLE_ADMIN")
	public TotalAmountDto getTotalCredit(@Valid @PathVariable int agencyId) {
		return sService.getTotalCredit(agencyId);
	}
	
	@GetMapping("/deposit/{agencyId}")
	@RolesAllowed("ROLE_ADMIN")
	public TotalAmountDto getTotalDeposit(@Valid @PathVariable int agencyId) {
		return sService.getTotalDeposit(agencyId);
	}
	
	@GetMapping("/deposit/{memberId}/{agencyId}")
//	@RolesAllowed("ROLE_USER")
	public TotalAmountDto getTotalDepositOfUser(@PathVariable int memberId,@PathVariable int agencyId) {
		return sService.getTotalDeposit(memberId, agencyId);
	}
	
	@GetMapping("/credit/{memberId}/{agencyId}")
//	@RolesAllowed("ROLE_USER")
	public TotalAmountDto getTotalCreditOfUser(@PathVariable int memberId,@PathVariable int agencyId) {
		return sService.getTotalCredit(memberId, agencyId);
	}
}
