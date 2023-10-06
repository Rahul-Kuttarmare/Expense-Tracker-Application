package com.gr.expenseTracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gr.expenseTracker.model.Agency;

public interface AgencyRepository extends JpaRepository<Agency, Integer> {

	Optional<Agency> findByAgencyName(String name);

}
