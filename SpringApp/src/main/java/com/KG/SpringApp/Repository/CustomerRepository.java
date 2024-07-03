package com.KG.SpringApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.KG.SpringApp.Entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>{

}
