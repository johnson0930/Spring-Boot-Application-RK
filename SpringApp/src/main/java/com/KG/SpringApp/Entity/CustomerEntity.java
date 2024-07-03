package com.KG.SpringApp.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer",schema = "kg_schema")
public class CustomerEntity {
	
	@Id
	@Column(name = "id")
	int id;
	@Column(name = "name")
	String name;
	@Column(name = "email")
	String email;
	

}
