package com.acme.demo.service;

import java.util.List;

import com.acme.demo.model.ACMEJobItems;
import com.acme.demo.model.ACMEJobs;

public interface ACMEService {

	List<ACMEJobs> getJobs();

	void createJobs(List<ACMEJobs> newJob);
	
	int updateJob(int id, String status) throws Exception;
	
	void deleteJob(Integer jobId) throws Exception;
	
	List<ACMEJobItems> getJobItems();
	
	void createJobItems(List<ACMEJobItems> newJob);
	
}
