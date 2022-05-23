package com.acme.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACMEJobs")
public class ACMEJobs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "job_reference")
	private String jobReference;
	
	@Column(name = "client_id")
	private int clientId;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "description")
	private String description;

	@Column(name = "delivery_date")
	private String deliveryDate;
	
	@Column(name = "delivery_time")
	private String deliveryTime;
	
	@Column(name = "created")
	private String created;
	
	@Column(name = "updated")
	private String updated;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "driver_rider_id")
	private  int driverRiderId;
	
	public int getId() {
		return id;
	}

	public String getJobReference() {
		return jobReference;
	}

	public void setJobReference(String jobReference) {
		this.jobReference = jobReference;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getDriverRiderId() {
		return driverRiderId;
	}

	public void setDriverRiderId(int driverRiderId) {
		this.driverRiderId = driverRiderId;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ACMEJobs [id=" + id + ", jobReference=" + jobReference + ", clientId=" + clientId + ", location="
				+ location + ", description=" + description + ", deliveryDate=" + deliveryDate + ", deliveryTime="
				+ deliveryTime + ", created=" + created + ", updated=" + updated + ", status=" + status
				+ ", driverRiderId=" + driverRiderId + "]";
	}

}