package com.gr.expenseTracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gr.expenseTracker.dto.AddRecordDto;
import com.gr.expenseTracker.dto.RecordDto;
import com.gr.expenseTracker.dto.TotalAmountDto;
import com.gr.expenseTracker.exception.UserExistException;
import com.gr.expenseTracker.model.RecordInfo;
import com.gr.expenseTracker.repository.RecordInfoRepository;

@Service
public class RecordInfoService {
	
	@Autowired
	RecordInfoRepository rRepository;
	
	@Autowired
	SummaryService sService;

	public RecordInfo addRecord(AddRecordDto record) {
		
		TotalAmountDto creditAmount = sService.getTotalCredit(record.getAgencyId());
		TotalAmountDto depositAmount  = sService.getTotalDeposit(record.getAgencyId());
		
		int balance = depositAmount.getAmount() - creditAmount.getAmount();
		System.out.println(depositAmount.getAmount());
		System.out.println(creditAmount.getAmount());
		System.out.println(balance);
		
		if(balance < record.getAmount() && record.getTransactionType().equals("credit")) {
			throw new UserExistException("amount must be less than "+balance);
		}
		RecordInfo info = new RecordInfo();
		
		info.setAmount(record.getAmount());	
		info.setDescription(record.getDescription());
		info.setMemberId(record.getMemberId());
		info.setAgencyId(record.getAgencyId());
		info.setTransactionType(record.getTransactionType());
		
		RecordInfo newRecord = new RecordInfo();

		newRecord =  rRepository.save(info);
		return newRecord;
	}

	public List<RecordDto> getAllRecords(int agencyId) {
		List<Object[]> list = rRepository.findAllByAgencyId(agencyId);
		List<RecordDto> newList = new ArrayList<>();
		if(!list.isEmpty()) {
			for (Object[] record : list) {
				RecordDto dto = new RecordDto();
				dto.setAmount((int)record[0]);
				dto.setDescription((String)record[1]);
				dto.setTransactionType((String)record[2]);
				dto.setMemberName((String)record[3]);
				newList.add(dto);
			}
		}
		return newList;
	}

	public List<RecordDto> getAllRecords(int agencyId, int memberId) {
		List<Object[]> list = rRepository.findAllByAgencyIdAndMemberId(agencyId, memberId);
		List<RecordDto> newList = new ArrayList<>();
		if(!list.isEmpty()) {
			for (Object[] record : list) {
				RecordDto dto = new RecordDto();
				dto.setAmount((int)record[0]);
				dto.setDescription((String)record[1]);
				dto.setTransactionType((String)record[2]);
				dto.setMemberName((String)record[3]);
				newList.add(dto);
			}
		}
		return newList;
	}
}
