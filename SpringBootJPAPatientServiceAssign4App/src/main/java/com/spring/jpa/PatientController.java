package com.spring.jpa;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {
	private final PatientService patientService;

	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}
	
	//add a patient object to the repo
	@RequestMapping(value ="/patient", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseStatus(value = HttpStatus.OK)
	public void addPatient(@RequestBody Patient p) throws Exception {
		 patientService.addPatient(p);
	}
	
	
	 @RequestMapping(value = "/patient/{OHIP_ID}", method = RequestMethod.GET)
	 Patient getPatient(@PathVariable("OHIP_ID") int OHIP_ID) throws Exception {
	     return patientService.getPatient(OHIP_ID);
	 }

	@RequestMapping(value ="/patients", method = RequestMethod.GET)
	public List<Patient> getPatients(){
		return patientService.getPatients();
	}
	
	
	@RequestMapping(value = "/patient/{OHIP_ID}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseStatus(value = HttpStatus.OK)
	 void daletePatient(@PathVariable("OHIP_ID") int OHIP_ID, @RequestBody Patient pat) throws Exception {
	    
	     patientService.deletePatient(OHIP_ID);
	 }
}
