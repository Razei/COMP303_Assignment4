package com.spring.jpa;

import javax.persistence.*;
import javax.validation.constraints.*;
@Entity
@Table(name="patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientId;

	@NotEmpty(message="First Name Required") @Size(min=2, max=60)
	private String firstName;
	
	@NotEmpty(message="Last Name Required") @Size(min=2, max=60)
	private String lastName;
	
	@NotNull(message="Age Required") @Min(0)
	private int age;
	
	@NotEmpty(message="Gender Required")
	private String gender;

	@NotNull(message="ohip # Required")
	private int ohip_ID;

	@NotEmpty(message="Address Required")
	private String address;
	
	@NotEmpty(message="City Required")
	private String city;
	
	@Pattern(regexp="^\\(?(\\d{3})\\)?[-]?(\\d{3}[-]?(\\d{4}))$", message="Phone Number is invalid")
	private String phone;
	
	public Patient() {

	}
	
	public Patient(String firstName, String lastName, int age, String gender, int ohip, String address, String city, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.ohip_ID = ohip;
		this.address = address;
		this.city = city;
		this.phone = phone;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getOhip_ID() {
		return ohip_ID;
	}

	public void setOhip_ID(int ohip_ID) {
		this.ohip_ID = ohip_ID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
