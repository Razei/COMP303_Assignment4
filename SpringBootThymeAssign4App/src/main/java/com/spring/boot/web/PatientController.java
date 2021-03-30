package com.spring.boot.web;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.boot.model.Patient;
import com.spring.boot.model.TableModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class PatientController {
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Patient> localPatients;
    private final String apiURL = "http://desktop-15eve81:8082";

    @GetMapping("/patients")
    public String getPatients(Model model) throws JsonProcessingException {
        final String uri = apiURL + "/patients";
        RestTemplate restTemplate = new RestTemplate();
        String jsonPatients = restTemplate.getForObject(uri, String.class);

        List<Patient> patients = Arrays.asList(mapper.readValue(jsonPatients, Patient[].class));
        localPatients = patients;

        TableModel<Patient>patientTableModel = new TableModel<>(
                new String[]{"OHIP ID", "First Name", "Last Name", "Age", "DOB", "Gender", "Address", "City", "Phone"},
                "Patients",
                patients
        );

        model.addAttribute("tableModel", patientTableModel);
        return "patient/patient-list";
    }

    @GetMapping("/patient/new")
    public String newPatient(){
        return "patient/new-patient";
    }

    @PostMapping("/patient/new")
    public String savePatient (@ModelAttribute Patient patient){
        RestTemplate restTemplate = new RestTemplate();
        final String uri = apiURL + "/patient/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        patient.setId(0L);
        HttpEntity<Patient> request = new HttpEntity<>(patient, headers);

        restTemplate.postForObject(uri, request, Patient.class);
        return "redirect:/patients";
    }

    @GetMapping("/editPatient/{id}")
    public String getEditPatient(@PathVariable String id, Model model){
        if (localPatients != null) {
            Patient patient = localPatients.stream()
                    .filter(p -> p.getId() == Long.parseLong(id))
                    .findAny()
                    .orElse(null);

            if (patient != null) {
                model.addAttribute("patient", patient);
                return "patient/new-patient";
            }
        }

        return "redirect:/patients";
    }

    @PostMapping("/editPatient/{id}")
    public String editPatient(@ModelAttribute Patient patient, @PathVariable String id){
        RestTemplate restTemplate = new RestTemplate();
        final String uri = apiURL + "/patient/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        patient.setId(Long.valueOf(id));
        HttpEntity<Patient> request = new HttpEntity<>(patient, headers);

        restTemplate.put(uri, request, Patient.class);

        return "redirect:/patients";
    }

    @PostMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable String id){
        final String uri = apiURL + "/patient/" + id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri);
        return "redirect:/patients";
    }
}
