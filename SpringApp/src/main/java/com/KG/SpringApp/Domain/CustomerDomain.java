package com.KG.SpringApp.Domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDomain {
	int id;
	String name;
	String email;
	
	List<AddressDomain> address;

}
