package com.spring.jpa;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name="centre")
public class Centre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@NotBlank(message = "Centre Name is mandatory")
	private String centreName;

	@NotBlank(message = "Address is mandatory")
	private String address;

	@NotBlank(message = "City is mandatory")
	private String city;

	@Pattern(regexp="^\\(?(\\d{3})\\)?[-]?(\\d{3}[-]?(\\d{4}))$", message="Phone Number is invalid")
	private String phone;

	@NotBlank(message = "Website is mandatory")
	@URL
	private String website;

	@NotBlank(message = "Email is mandatory")
	@Email
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
