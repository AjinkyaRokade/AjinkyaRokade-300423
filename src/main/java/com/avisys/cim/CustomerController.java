package com.avisys.cim;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService custServ;
	
	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return custServ.getAllCustomers();
	}
	
	@GetMapping("/byFirstName")
	public List<Customer> getAllCustomersByFirstName(@RequestParam String name){
		return custServ.getAllCustByFirstName(name);
	}
	
	@GetMapping("/byLastName")
	public List<Customer> getAllCustomersByLastName(@RequestParam String name){
		return custServ.getAllCustByLastName(name);
	}
	
	@GetMapping("/byMobNo")
	public List<Customer> getAllCustomersByMobNo(@RequestParam String mobNo){
	
		return custServ.getAllCustByMobNo(mobNo);
	}
	

}
