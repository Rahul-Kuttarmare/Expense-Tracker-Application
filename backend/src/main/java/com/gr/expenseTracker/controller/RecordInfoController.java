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

import com.gr.expenseTracker.dto.AddRecordDto;
import com.gr.expenseTracker.dto.RecordDto;
import com.gr.expenseTracker.model.RecordInfo;
import com.gr.expenseTracker.service.RecordInfoService;

@RestController
@RequestMapping("/api/v3")
public class RecordInfoController {
	
	@Autowired
	RecordInfoService rService;

	@PostMapping("/record")
	@RolesAllowed("ROLE_ADMIN")
	public RecordInfo addNewRecord(@Valid @RequestBody AddRecordDto record){
		return rService.addRecord(record);
	}
	
	@GetMapping("/record/{agencyId}")
	@RolesAllowed("ROLE_ADMIN")
	public List<RecordDto> getAllRecords(@Valid @PathVariable int agencyId) {
		return rService.getAllRecords(agencyId);
	}
	
	@GetMapping("/record/{agencyId}/{memberId}")
	public List<RecordDto> getAllRecordsByMemberId(@PathVariable int agencyId, @PathVariable int memberId) {
		return rService.getAllRecords(agencyId, memberId);
}
}
