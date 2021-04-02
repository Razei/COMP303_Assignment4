package com.spring.jpa;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="test")
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int testId;
	
	@NotNull(message="Test Date Required")
	@NotBlank(message = "Test Date is mandatory")
	private String testDate;

	@NotBlank(message = "Symptoms is mandatory")
	private String symptoms;

	@NotBlank(message = "Status is mandatory")
	private String status;
	

	@NotNull(message="Patient ID needed ")
	private int patient_id;
	
	public Test() {
		
	}
	
	public Test(String testDate, String symptoms, String status, int patient_id) {
		this.testDate = testDate;
		this.symptoms = symptoms;
		this.status = status;
		this.patient_id = patient_id;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestDate() {
		return testDate;
	}

	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	
	
}
