package com.KG.SpringApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.KG.SpringApp.Entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer>{

}
