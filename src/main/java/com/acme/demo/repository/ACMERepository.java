package com.acme.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.acme.demo.model.ACMEJobs;

public interface ACMERepository extends JpaRepository<ACMEJobs, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE ACMEJobs SET status = :status WHERE id = :id")
	int updatejob(int id, String status);
}
