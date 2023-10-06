package com.gr.expenseTracker.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gr.expenseTracker.dto.TotalAmountDto;
import com.gr.expenseTracker.repository.RecordInfoRepository;

@Service
public class SummaryService {
	
	@Autowired
	RecordInfoRepository rRepository;

	public TotalAmountDto getTotalCredit(int agencyId) {
		Optional<Integer> creditAmount = rRepository.findTotalCreditAmountByAgencyId(agencyId);
		TotalAmountDto data = new TotalAmountDto();
		if(!creditAmount.isEmpty()) {
			Integer dto;
			dto= creditAmount.get();
			data.setAmount(dto);			
		}	
		return data;
	}
	
	public TotalAmountDto getTotalDeposit(int agencyId) {
		Optional<Integer> depositAmount = rRepository.findTotalDepositAmountByAgencyId(agencyId);
		TotalAmountDto data = new TotalAmountDto();
		if(!depositAmount.isEmpty()) {
			Integer dto;
			dto= depositAmount.get();
			data.setAmount(dto);			
		}	
		return data;
	}

	public TotalAmountDto getTotalDeposit(int memberId, int agencyId) {
		Optional<Integer> depositAmount = rRepository.findTotalDepositAmountByMemberIdAndAgencyId(memberId,agencyId);
		TotalAmountDto data = new TotalAmountDto();
		if(!depositAmount.isEmpty()) {
			Integer dto;
			dto= depositAmount.get();
			data.setAmount(dto);			
		}	
		return data;
	}

	public TotalAmountDto getTotalCredit(int memberId, int agencyId) {
		Optional<Integer> depositAmount = rRepository.findTotalCreditAmountByMemberIdAndAgencyId(memberId,agencyId);
		TotalAmountDto data = new TotalAmountDto();
		if(!depositAmount.isEmpty()) {
			Integer dto;
			dto= depositAmount.get();
			data.setAmount(dto);			
		}	
		return data;
	}

}
