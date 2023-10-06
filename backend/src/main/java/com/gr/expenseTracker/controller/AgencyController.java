package com.gr.expenseTracker.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gr.expenseTracker.dto.AddAgencyDto;
import com.gr.expenseTracker.model.Agency;
import com.gr.expenseTracker.service.AgencyService;

@RestController
@RequestMapping("/api/v1")
public class AgencyController {
	
	@Autowired
	AgencyService agencyService;
	
	@GetMapping("/agency")
	public List<Agency> getAllAgency() {
		return agencyService.getAllAgency();
	}
	
	@GetMapping("/agency/{agencyId}")
	public Optional<Agency> getAgencyById(@Valid @PathVariable int agencyId) {
		return agencyService.getAgencyById(agencyId);
	}
	
	@PostMapping("/agency")
	public Agency addAgency(@Valid @RequestBody AddAgencyDto agency){
		return agencyService.addAgency(agency);
	}
}
