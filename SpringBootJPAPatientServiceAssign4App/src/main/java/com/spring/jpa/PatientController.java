package com.spring.jpa;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {
	private final PatientService patientService;

	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}

	@RequestMapping(value ="/patient", method = RequestMethod.GET)
	public Patient create() {
		try {
			Patient patient = new Patient();

			patient.setFirstName("John");
			patient.setLastName("Doe");
			patient.setAddress("Somewhere Drive");
			patient.setAge(25);
			patient.setCity("Happyville");
			patient.setGender("M");
			patient.setOhip_ID(1312513);
			patient.setPhone("905-554-0686");

			patientService.addPatient(patient);
			return patient;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@RequestMapping(value ="/patients", method = RequestMethod.GET)
	public List<Patient> getPatients(){
		return patientService.getPatients();
	}
}
