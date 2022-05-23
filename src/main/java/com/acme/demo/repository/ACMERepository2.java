package com.acme.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acme.demo.model.ACMEJobItems;

public interface ACMERepository2 extends JpaRepository<ACMEJobItems, Integer>{

}
