package com.acme.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.acme.demo.model.ACMEJobItems;
import com.acme.demo.model.ACMEJobs;
import com.acme.demo.service.ACMEService;


@RestController
public class ACMEController {
	
	@Autowired
	private ACMEService acmeService;
	
	
	@GetMapping("/getJobs")
	public ResponseEntity<List<ACMEJobs>> getJobs(){
		List<ACMEJobs> jobList = acmeService.getJobs();
		return new ResponseEntity<List<ACMEJobs>>(jobList, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/createJobs", method = RequestMethod.POST)
	public ResponseEntity<String> createJobs(@RequestBody List<ACMEJobs> newJobs) {
		acmeService.createJobs(newJobs);
		return ResponseEntity.ok("Added Successfully !!");
	}
	
	
	@RequestMapping(value = "/updateJob", method = RequestMethod.PUT)
	public ResponseEntity<String> updateJob(@RequestParam int id, @RequestParam String status){
		try {
			int noOfRowsUpdated = acmeService.updateJob(id, status);
			if(noOfRowsUpdated == 0) {
				return ResponseEntity.ok("No rows updated");
			}
		}catch(Exception ex) {
			System.err.println(ex.getMessage());
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok("Updated Successfully !!");
	}
	
	@RequestMapping(value = "/deleteJob", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteJob(@RequestParam int jobId) {
		try {
			acmeService.deleteJob(jobId);
		}catch(Exception ex) {
			System.err.println(ex.getMessage());
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	    
		}
		
		return ResponseEntity.ok("Deleted Successfully !!");
	}
	
	@GetMapping("/getJobItems")
	public ResponseEntity<List<ACMEJobItems>> getJobItems(){
			
		List<ACMEJobItems> jobItemList = acmeService.getJobItems();
		
		return new ResponseEntity<List<ACMEJobItems>>(jobItemList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/createJobItems", method = RequestMethod.POST)
	public ResponseEntity<String> createJobItems(@RequestBody List<ACMEJobItems> newJobs) {
			
		acmeService.createJobItems(newJobs);
			
		return ResponseEntity.ok("Added Successfully !!");
	}
}
