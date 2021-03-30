package com.spring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    //create a hash map of patients, will use their ohip id as the key and the patient object itself as the value
    /*Map<Integer, Patient> patient = new HashMap<>();*/
    @Autowired
    private PatientRepository patientRepository;

    public void addPatient(Patient pat) throws Exception {
		Patient patient = patientRepository.findById(pat.getOhip_ID()).orElse(null);

        if (patient != null) {
            throw new Exception("A Patient already exists with that OHIP ID");
        } else {
            /*patient.put(pat.getOhip_ID(), pat);*/
            patientRepository.save(pat);
        }
    }


    //return the patient hashmap

    public List<Patient> getPatients() {
        return patientRepository.findAll();
        /*return patient.values();*/
    }

    //get a specific patient
    public Patient getPatient(int ohip_Id) throws Exception {
		Patient patient = patientRepository.findById(ohip_Id).orElse(null);

        if (patient != null) {
			return patientRepository.findById(ohip_Id).orElse(null);
//            return patient.get(ohip_Id);
        } else {
            throw new Exception("Patient Id not found");
        }
    }


    //update a patient
    public void updatePatient(Patient pat) throws Exception {
		Patient patient = patientRepository.findById(pat.getOhip_ID()).orElse(null);

        if (patient != null) {
			patientRepository.save(pat);
            /*patient.put(pat.getOhip_ID(), pat);*/
        } else {
            throw new Exception("Patient Id not found");
        }
    }

    //delete patient
    public void deletePatient(int ohip_Id) throws Exception {
		Patient patient = patientRepository.findById(ohip_Id).orElse(null);

        if (patient != null) {
			patientRepository.deleteById(ohip_Id);
            /*patient.remove(ohip_Id);*/
        } else {
            throw new Exception("Patient  Id not found");
        }
    }


}
