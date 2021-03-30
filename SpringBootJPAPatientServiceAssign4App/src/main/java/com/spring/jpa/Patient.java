package com.spring.jpa;

import javax.persistence.*;

@Entity
@Table(name="patient")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="patientId")
	private int patientId;

	@Column(name="firstName")
	private String firstName;

	@Column(name="lastName")
	private String lastName;

	@Column(name="age")
	private int age;

	@Column(name="gender")
	private String gender;

	@Column(name="ohip_ID")
	private int ohip_ID;

	@Column(name="address")
	private String address;

	@Column(name="city")
	private String city;

	@Column(name="phone")
	private String phone;
	
	public Patient() {

	}
	
	public Patient(String firstName, String lastName, int age, String gender,int ohip,String address, String city, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.ohip_ID = ohip;
		this.address = address;
		this.city = city;
		this.phone = phone;
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
