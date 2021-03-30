package com.spring.jpa.patient;

import java.util.*;
import org.springframework.stereotype.Service;
@Service
public class PatientService {
	
	//create a hash map of patients, will use their ohip id as the key and the patient object itself as the value
	Map<Integer, Patient> patient = new HashMap<>();
	
	 public void addPatient(Patient pat) throws Exception {
	        if(patient.containsKey(pat.getOhip_ID())) {
	            throw new Exception("A Paitent already exists with that OHIP ID");
	        }
	        else {
	            patient.put(pat.getOhip_ID(), pat);
	        }
	    }
	 
	 
	 //return the patient hashmap
	 
	 public Iterable<Patient> getPatients(){
	        return patient.values();
	    }
	 
	 //get a specific patient
	  public Patient getPatient(int ohip_Id) throws Exception {

	        if(patient.containsKey(ohip_Id)) {
	            return patient.get(ohip_Id);
	        }
	        else {
	            throw new Exception("Patient Id not found");
	        }
	    }
	  
	  
	  //update a patient 
	  public void updatePatient(Patient pat) throws Exception {
	        if(patient.containsKey(pat.getOhip_ID())) {
	            patient.put(pat.getOhip_ID(), pat);
	        }
	        else {
	            throw new Exception("Patient Id not found");
	        }
	    }
	  
	  //delete patient
	  public void deletePatient(int ohip_Id) throws Exception {
	        if(patient.containsKey(ohip_Id)) {
	            patient.remove(ohip_Id);
	        }
	        else {
	            throw new Exception("Patient  Id not found");
	        }
	    }


}
