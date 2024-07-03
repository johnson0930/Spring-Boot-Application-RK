package com.KG.SpringApp.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "address",schema = "kg_schema")
public class AddressEntity {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "line1")
	private String line1;
	
	@Column(name = "line2")
	private String line2;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String State;  
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "zipcode")
	private int zipcode;
	
	@Column(name = "customer_id")
	private int customer_id;

}
