package com.gr.expenseTracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gr.expenseTracker.dto.AddMemberDto;
import com.gr.expenseTracker.exception.UserExistException;
import com.gr.expenseTracker.model.MemberInfo;
import com.gr.expenseTracker.repository.MemberInfoRepository;

@Service
public class MemberInfoService {
	
	@Autowired
	MemberInfoRepository mRepository;
	
	@Autowired 
	BCryptPasswordEncoder encoder;
	
	public MemberInfo createMember(AddMemberDto memberDto) {
		List<MemberInfo> optional = mRepository.findByUserNameAndAgencyId(memberDto.getUserName(), memberDto.getAgencyId());
		if(!optional.isEmpty()) {
			throw new UserExistException("user with same name already exist");	
			}
		 MemberInfo list = new  MemberInfo();
		 MemberInfo a = new MemberInfo();
			a.setUserName(memberDto.getUserName());
			a.setAgencyId(memberDto.getAgencyId());
			a.setAge(memberDto.getAge());
			a.setAddress(memberDto.getAddress());
			String pass = encoder.encode(memberDto.getPassword());
			a.setPassword(pass);
			a.setRole(memberDto.getRole());
			list = mRepository.save(a);
			return list;
		}

	public List<MemberInfo> getAllMembers(Integer agencyId) {
		
		List<MemberInfo> list = new ArrayList<>();
		
		 list = mRepository.findAllByAgencyId(agencyId);
		return list;
	}

}
