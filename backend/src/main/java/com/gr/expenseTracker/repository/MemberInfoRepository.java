package com.gr.expenseTracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.gr.expenseTracker.model.MemberInfo;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, Integer> {

//	@Query(value = "select member_id, username from memberinfo where agency_id = :agencyID", nativeQuery=true)
//	List<MemberInfo> findAllByAgencyId(@Param("agencyId") Integer agencyId);

	List<MemberInfo> findAllByAgencyId(@Param("agencyId") Integer agencyId);

	Optional<MemberInfo> findByUserName(String userName);

	List<MemberInfo> findByUserNameAndAgencyId(String userName, Integer agencyId);

//	Optional<MemberInfo> findByAgencyIdAndUserName(int agencyId, String userName);

	Optional<MemberInfo> findByAgencyIdAndUserNameAndRole(int agencyId, String userName, String role);

	Optional<MemberInfo> findByAgencyIdAndUserName(int agencyId, String userName);

}
