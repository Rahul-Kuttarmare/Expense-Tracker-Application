package com.gr.expenseTracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gr.expenseTracker.dto.AddAgencyDto;
import com.gr.expenseTracker.exception.UserExistException;
import com.gr.expenseTracker.model.Agency;
import com.gr.expenseTracker.repository.AgencyRepository;

@Service
public class AgencyService {
	
	
	@Autowired
	AgencyRepository aRepository;
	
	public List<Agency> getAllAgency() {
		return aRepository.findAll();
		}

	public Agency addAgency(AddAgencyDto agency) {
		Optional<Agency> optional = aRepository.findByAgencyName(agency.getName());
		Agency list = new Agency();
		if(!optional.isEmpty()) {
			throw new UserExistException("angency with same name already exist");
		}else {
			Agency a = new Agency();
			a.setAgencyName(agency.getName());
			a.setDescription(agency.getDescription());
			list = aRepository.save(a);
		}
		return list;
	}

	public Optional<Agency> getAgencyById(int id) {
		Optional<Agency> agency = aRepository.findById(id);
		return agency;
	}
}
