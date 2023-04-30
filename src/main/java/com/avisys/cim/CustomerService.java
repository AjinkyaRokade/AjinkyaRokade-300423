package com.avisys.cim;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerRepository repo; 
	public ResponseEntity<List<Customer>> getAllCustomers() {
		
		return new ResponseEntity<List<Customer>>(repo.findAll(), HttpStatus.OK);
	}
	public List<Customer> getAllCustByFirstName(String name) {
		
		return repo.findByFirstNameContainingIgnoreCase(name);
	}
	
	public List<Customer> getAllCustByLastName(String name) {
		
		return repo.findByLastNameContainingIgnoreCase(name);
	}

	public Customer getAllCustByMobNo(String mobNo) {
		
		return repo.findByMobileNumber(mobNo);
	}
	public ResponseEntity<String> registerCustomer(Customer cust) {
		
	Customer customer = repo.findByMobileNumber(cust.getMobileNumber());
		if(customer!=null) {
			return new ResponseEntity<String>("Cannot register, MobNo already present", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else
		{
			repo.save(cust);
			return new ResponseEntity<String>("Customer registered successfully", HttpStatus.OK);	
		}
		
	}

}
