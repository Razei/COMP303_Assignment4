package com.spring.jpa.patient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
	@RequestMapping(value ="/patient", method = RequestMethod.GET)
	public Patient create() {
		Patient patient = new Patient();
		
		patient.setFirstName("John");
		patient.setLastName("Doe");
		patient.setAddress("Somewhere Drive");
		patient.setAge(25);
		patient.setCity("Happyville");
		patient.setGender("M");
		patient.setOhip_ID(1312513);
		patient.setPhone("905-554-0686");
		return patient;
		
		
	}
}
