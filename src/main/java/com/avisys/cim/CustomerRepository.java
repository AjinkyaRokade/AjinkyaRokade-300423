package com.avisys.cim;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


	ResponseEntity<List<Customer>> findByFirstNameContaining(String name);

	List<Customer> findByFirstNameContainingIgnoreCase(String name);

	List<Customer> findByMobileNumber(String mobNo);

	List<Customer> findByLastNameContainingIgnoreCase(String name);

	
}
