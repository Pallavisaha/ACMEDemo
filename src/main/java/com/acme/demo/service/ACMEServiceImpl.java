package com.acme.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.demo.model.ACMEJobItems;
import com.acme.demo.model.ACMEJobs;
import com.acme.demo.repository.ACMERepository;
import com.acme.demo.repository.ACMERepository2;

@Service
@Transactional
public class ACMEServiceImpl implements ACMEService{
	
	@Autowired
	private ACMERepository jobRepository;
	
	@Autowired
	private ACMERepository2 jobItemRepository;
	
	public ACMEServiceImpl(ACMERepository repository, ACMERepository2 repository2) {
		this.jobRepository = repository;
		this.jobItemRepository = repository2;
	}
		

	@Override
	public List<ACMEJobs> getJobs(){
		return jobRepository.findAll();
	}
	
	@Override
	public void createJobs(List<ACMEJobs> newJobs) {
		
		jobRepository.saveAll(newJobs);
	}
	
	@Override
	public int updateJob(int jobId, String status) throws Exception {
		
		int noOfRowsUpdated = jobRepository.updatejob(jobId, status);
		System.out.println("No of rows update = " + noOfRowsUpdated);
		return noOfRowsUpdated;
	}
	
	@Override
	public void deleteJob(Integer jobId) throws Exception{
		jobRepository.deleteById(jobId);
		
	}

	@Override
	public List<ACMEJobItems> getJobItems() {
		return jobItemRepository.findAll();
	}



	@Override
	public void createJobItems(List<ACMEJobItems> newJob) {
		jobItemRepository.saveAll(newJob);
		
	}

}
