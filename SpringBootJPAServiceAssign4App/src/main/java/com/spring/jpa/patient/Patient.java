package com.spring.jpa.patient;

public class Patient {
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private int ohip_ID;
	private String address;
	private String city;
	private String phone;
	
	public Patient() {
		super();
	}
	
	public Patient(String firstName, String lastName, int age, String gender,int ohip,String address, String city, String phone) {
		super();
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
