package com.spring.jpa;

import javax.persistence.*;

@Entity
@Table(name="test")
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="testid")
	private int testId;
	
	@Column(name="testdate")
	private String testDate;
	
	@Column(name="symptoms")
	private String symptoms;
	
	@Column(name="status")
	private String status;
	
	@Column(name="patient_id")
	private int patient_id;
	
	public Test() {
		
	}
	
	public Test(String testDate, String symtpoms, String status, int patient_id) {
		this.testDate = testDate;
		this.symptoms = symtpoms;
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
