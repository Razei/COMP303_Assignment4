package com.spring.jpa;

import com.spring.jpa.model.TableModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PatientController {
    private final PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/")
    public String getPatients(Model model) {
        TableModel<Patient> patientTableModel = new TableModel<>(
                new String[]{"OHIP ID", "First Name", "Last Name", "Age", "Gender", "Address", "City", "Phone"},
                "Patients",
                patientService.getPatients()
        );

        model.addAttribute("tableModel", patientTableModel);
        return "patient-list";
    }

    @GetMapping("/patient/new")
    public String newPatient(Model model){
        model.addAttribute("patient", new Patient());
        return "new-patient";
    }

    @PostMapping("/patient/new")
    public String savePatient (@Valid Patient patient, BindingResult result, Model model) throws Exception {
        if (result.hasErrors()) {
            model.addAttribute("patient", patient);
            return "new-patient";
        }

        try {
            patientService.addPatient(patient);
            return "redirect:/";
        } catch (Exception ex){
            result.rejectValue("ohip_ID", "error.ohip_ID", ex.getMessage());
            model.addAttribute("patient", patient);
            return "new-patient";
        }
    }

    @GetMapping("/editPatient/{id}")
    public String getEditPatient(@PathVariable String id, Model model) throws Exception {
        Patient patient = patientService.getPatient(Integer.parseInt(id));

        if (patient != null) {
            model.addAttribute("patient", patient);
            model.addAttribute("update", true);
            return "new-patient";
        }

        return "redirect:/";
    }

    @PostMapping("/editPatient/{id}")
    public String editPatient(@PathVariable int id, @Valid Patient patient, BindingResult result, Model model){

        if (result.hasErrors()) {
            model.addAttribute("update", true);
            patient.setOhip_ID(id);
            model.addAttribute("patient", patient);
            return "new-patient";
        }

        try {
            patientService.updatePatient(patient);
            return "redirect:/";
        } catch (Exception ex){
            result.rejectValue("ohip_ID", "error.ohip_ID", ex.getMessage());
            model.addAttribute("update", true);
            patient.setOhip_ID(id);
            model.addAttribute("patient", patient);
            return "new-patient";
        }
    }

    @PostMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable String id) throws Exception {
        patientService.deletePatient(Integer.parseInt(id));
        return "redirect:/";
    }
}
