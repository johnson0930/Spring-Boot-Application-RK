package com.KG.SpringApp.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.KG.SpringApp.Domain.AddressDomain;
import com.KG.SpringApp.Domain.CustomerDomain;
import com.KG.SpringApp.Entity.AddressEntity;
import com.KG.SpringApp.Entity.CustomerEntity;
import com.KG.SpringApp.Repository.AddressRepository;
import com.KG.SpringApp.Repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	public void createCustomer(CustomerDomain customer ) {
		
			
			CustomerEntity customerEntity = new CustomerEntity();
//			customerEntity.setId(customer.getId());
			customerEntity.setName(customer.getName());
			customerEntity.setEmail(customer.getEmail());
			customerEntity=customerRepository.save(customerEntity);
			
			
			int cus_id=customerEntity.getId();
			List<AddressDomain> listAddress=customer.getAddress();	
			List<AddressEntity> addressEntites=listAddress.stream().map(address-> {
				AddressEntity addressEntity =new AddressEntity();
				addressEntity.setCustomer_id(cus_id);
				addressEntity.setId(address.getId());
				addressEntity.setLine1(address.getLine1());
				addressEntity.setLine2(address.getLine2());
				addressEntity.setCity(address.getCity());
				addressEntity.setState(address.getState());
				addressEntity.setCity(address.getCity());
				addressEntity.setCountry(address.getCountry());
				addressEntity.setZipcode(address.getZipcode());
				return addressEntity;
					}).collect(Collectors.toList());
			addressRepository.saveAll(addressEntites);
		
	
		
	}
	public CustomerDomain readCustomer(int id) {
		
		Optional<CustomerEntity> optionalCustomerEntity=customerRepository.findById(id);
		
		if(optionalCustomerEntity.isPresent()) {
			CustomerEntity customerEntity=optionalCustomerEntity.get();
//			System.out.println(customerValue);
			
			CustomerDomain customer=new CustomerDomain();
			customer.setId(customerEntity.getId());
			customer.setName(customerEntity.getName());
			customer.setEmail(customerEntity.getEmail());
			return customer;
		}else {
			System.out.println("there is no customer available for given id "+id);
			return null;
		}
	}
	
	public CustomerEntity updateCustomer(CustomerDomain customer) {
		Optional<CustomerEntity > customerEntity=customerRepository.findById(customer.getId());
		
		if(customerEntity.isPresent()) {
			CustomerEntity cus=new CustomerEntity();
			cus.setId(customer.getId());
			cus.setName(customer.getName());
			cus.setEmail(customer.getEmail());
			customerRepository.save(cus);
			System.out.println("updated in the background");
			return cus;
		}else {
			CustomerEntity cus=new CustomerEntity();
			System.out.println("there is no customer available for given id "+cus.getId());
			return null;
		}
	}
	
	public void deleteCustomer(int id) {
		
		customerRepository.deleteById(id);
	}
	

}
