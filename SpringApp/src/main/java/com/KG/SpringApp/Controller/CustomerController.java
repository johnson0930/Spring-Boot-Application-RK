package com.KG.SpringApp.Controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.KG.SpringApp.Domain.CustomerDomain;
import com.KG.SpringApp.Entity.CustomerEntity;
import com.KG.SpringApp.Service.CustomerService;



@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="/customer-service/create", method=RequestMethod.POST)
	public ResponseEntity<CustomerDomain> createCustomer(@RequestBody CustomerDomain customer) {
		customerService.createCustomer(customer);
		ResponseEntity response = new ResponseEntity("successfully created the customer",HttpStatus.CREATED);
		
		
		
//		System.out.println("this is microservice class");
//		System.out.println("the customer request body"+customer);
		
		return response;
		
	}
	
	@RequestMapping(value = "/customer-service/read",method = RequestMethod.GET)
	public ResponseEntity<CustomerDomain> readCustomer(@RequestParam(name = "id")int id){
	
//	@RequestMapping(value = "/customer-service/read/{cust-id}",method = RequestMethod.GET)
//	public ResponseEntity<CustomerDomain> readCustomer(@PathVariable(name = "cust-id")int id){
		System.out.println("the guiven id is "+id);
		CustomerDomain customer= customerService.readCustomer(id);
		
		if(customer==null) {
			ResponseEntity response= new ResponseEntity("GIven customer is not found",HttpStatus.NOT_FOUND);
			return response;
		}else {
			ResponseEntity response= new ResponseEntity(customer,HttpStatus.OK);
			return response;
		}
	}
	
	@RequestMapping(value = "/customer-service/update",method = RequestMethod.PUT)
	public ResponseEntity<CustomerDomain> updateCustomer(@RequestBody CustomerDomain cutomer) { 
		CustomerEntity customer=customerService.updateCustomer(cutomer);
		 
		ResponseEntity response= new ResponseEntity(customer,HttpStatus.OK);
		return response;
		
	}
	@RequestMapping(value = "/customer-service/delete",method = RequestMethod.DELETE)
	public ResponseEntity<CustomerDomain> deleteCustomer(@RequestParam(name = "id")int id) {
		customerService.deleteCustomer(id);
		ResponseEntity response= new ResponseEntity("deleted",HttpStatus.OK);
		return response;	
	}
}
