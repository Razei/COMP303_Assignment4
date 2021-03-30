package com.spring.jpa;

import javax.persistence.*;

@Entity
@Table(name="centre")
public class Centre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="centreName")
	private String centreName;

	@Column(name="address")
	private String address;

	@Column(name="city")
	private String city;

	@Column(name="phone")
	private String phone;

	@Column(name="website")
	private String website;

	@Column(name="email")
	private String email;
	
	public Centre() {

	}

	public Centre(String centreName, String address, String city, String phone, String website, String email) {
		this.centreName = centreName;
		this.address = address;
		this.city = city;
		this.phone = phone;
		this.website = website;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCentreName() {
		return centreName;
	}

	public void setCentreName(String centreName) {
		this.centreName = centreName;
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

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
