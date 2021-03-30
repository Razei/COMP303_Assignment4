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

    public Patient addPatient(Patient pat) throws Exception {
		Patient patient = patientRepository.findPatientByOhip_ID(pat.getOhip_ID());

        if (patient != null) {
            throw new Exception("A Patient already exists with that OHIP ID");
        } else {
            /*patient.put(pat.getOhip_ID(), pat);*/
            pat.setPatientId(0);
            return patientRepository.save(pat);
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
		Patient patient = patientRepository.findPatientByOhip_ID(pat.getOhip_ID());

        if (patient != null) {
            pat.setPatientId(patient.getPatientId());
			patientRepository.save(pat);
            /*patient.put(pat.getOhip_ID(), pat);*/
        } else {
            throw new Exception("Patient Id not found");
        }
    }

    //delete patient
    public void deletePatient(int ohip_Id) throws Exception {
		Patient patient = patientRepository.findPatientByOhip_ID(ohip_Id);

        if (patient != null) {
			patientRepository.deletePatientByOhip_ID(ohip_Id);
            /*patient.remove(ohip_Id);*/
        } else {
            throw new Exception("OHIP Id not found");
        }
    }
}
