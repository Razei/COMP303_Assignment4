package com.spring.jpa;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    //add a patient object to the repo
    @RequestMapping(value = "/patient", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public Patient addPatient(@RequestBody Patient p) throws Exception {
        return patientService.addPatient(p);
    }

    @RequestMapping(value = "/patient/{OHIP_ID}", method = RequestMethod.GET)
    Patient getPatient(@PathVariable("OHIP_ID") int OHIP_ID) throws Exception {
        return patientService.getPatient(OHIP_ID);
    }

    @RequestMapping(value = "/patients", method = RequestMethod.GET)
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    @RequestMapping(value = "/patient/{OHIP_ID}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    void updatePatient(@PathVariable("OHIP_ID") int OHIP_ID, @RequestBody Patient patient) throws Exception {
        patientService.updatePatient(patient);
    }

    @RequestMapping(value = "/patient/{OHIP_ID}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    void deletePatient(@PathVariable("OHIP_ID") int OHIP_ID) throws Exception {
        patientService.deletePatient(OHIP_ID);
    }
}
