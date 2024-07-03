package com.KG.SpringApp.Domain;

import lombok.Data;

@Data
public class AddressDomain {
	int id;
	String line1;
	String line2;
	String city;
	String state;
	String country;
	int zipcode;
	int customer_id;

}
