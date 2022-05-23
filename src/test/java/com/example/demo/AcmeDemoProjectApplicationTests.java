package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.acme.demo.AcmeDemoProjectApplication;
import com.acme.demo.model.ACMEJobs;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
@SpringBootTest(classes = AcmeDemoProjectApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AcmeDemoProjectApplicationTests {

	@LocalServerPort
	Integer port;
	
	@Autowired
	TestRestTemplate restTemplate;
	
	
	@Test
	public void testGetJobs() {
		
		ACMEJobs acmeJob = new ACMEJobs();
		acmeJob.setClientId(1);
		acmeJob.setJobReference("1A");
		acmeJob.setLocation("123 Someplace");
		acmeJob.setDescription("A thing");
		acmeJob.setDeliveryDate("2021-06-14");
		acmeJob.setDeliveryTime("9:00:00");
		acmeJob.setCreated("2021-06-12 9:30:00");
		acmeJob.setUpdated("2021-06-04 10:32:33");
		acmeJob.setStatus("New");
		acmeJob.setDriverRiderId(1212);
		
		List<ACMEJobs> list = new ArrayList<ACMEJobs>();
		list.add(acmeJob);
		
		restTemplate.postForEntity("http:localhost:"+port+"/getJobs", list, List.class);
		
		
		ResponseEntity<List> result = restTemplate.getForEntity("http:localhost:"+port+"/getJobs",List.class);
		System.out.println(result);
		assertNotNull(result);
	}
	
	
	
	  @Test 
	  public void testCreateJobs() { 
		  ACMEJobs newAcmeJob = new ACMEJobs();
		  newAcmeJob.setClientId(110); newAcmeJob.setJobReference("2B");
		  newAcmeJob.setLocation("1212 Some other place");
		  newAcmeJob.setDescription("some stuff");
		  newAcmeJob.setDeliveryDate("2021-06-17");
		  newAcmeJob.setDeliveryTime("10:00:00");
		  newAcmeJob.setCreated("21-06-10 14:32:01");
		  newAcmeJob.setUpdated("21-06-10 14:32:01"); newAcmeJob.setStatus("New");
		  newAcmeJob.setDriverRiderId(1213);
		  
		  List<ACMEJobs> newJobs = new ArrayList<ACMEJobs>(); 
		  newJobs.add(newAcmeJob);
		  
		  String response = "Added Successfully !!";
		  
		  ResponseEntity<List> result = restTemplate.postForEntity("http:localhost:"+port+"/createJobs", newJobs,List.class); 
		  assertEquals(response, result);
	  }
	 
}
