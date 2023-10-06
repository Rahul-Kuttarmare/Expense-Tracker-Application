package com.gr.expenseTracker.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gr.expenseTracker.model.RecordInfo;

public interface RecordInfoRepository extends JpaRepository<RecordInfo, Integer> {

	
	@Query(value = "select sum(amount) from recordinfo where agency_id =:agencyId  and transaction_type = 'credit';\r\n"
			+ "", nativeQuery=true)
	Optional<Integer> findTotalCreditAmountByAgencyId(@Param("agencyId") Integer agencyId);
	
	
	@Query(value = "select sum(amount) from recordinfo where agency_id =:agencyId and transaction_type = 'deposit';\r\n"
			+ "", nativeQuery=true)
	Optional<Integer> findTotalDepositAmountByAgencyId(@Param("agencyId") Integer agencyId);


	@Query(value = "select r.amount, r.description, r.transaction_type, m.username from \r\n"
			+ "recordinfo r\r\n"
			+ "join memberinfo m\r\n"
			+ "on r.member_id = m.member_id\r\n"
			+ "where r.agency_id =:agencyId", nativeQuery = true)
	List<Object[]> findAllByAgencyId(@Param("agencyId")Integer agencyId);

	@Query(value = "select sum(amount) from recordinfo where transaction_type = 'deposit' and member_id =:memberId and agency_id =:agencyId ;\r\n"
			+ "", nativeQuery=true)
	Optional<Integer> findTotalDepositAmountByMemberIdAndAgencyId(@Param("memberId")int memberId, @Param("agencyId")int agencyId);


	@Query(value = "select sum(amount) from recordinfo where transaction_type = 'credit' and member_id =:memberId and agency_id =:agencyId ;\r\n"
			+ "", nativeQuery=true)
	Optional<Integer> findTotalCreditAmountByMemberIdAndAgencyId(@Param("memberId")int memberId, @Param("agencyId")int agencyId);


	@Query(value = "select r.amount, r.description, r.transaction_type, m.username from \r\n"
			+ "recordinfo r\r\n"
			+ "join memberinfo m\r\n"
			+ "on r.member_id = m.member_id\r\n"
			+ "where r.agency_id =:agencyId and r.member_id =:memberId", nativeQuery = true)
	List<Object[]> findAllByAgencyIdAndMemberId(@Param("agencyId") int agencyId, @Param("memberId") int memberId);


	

}
