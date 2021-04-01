package com.spring.jpa;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.jpa.model.TableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

@Controller
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/")
    public String getTests(Model model) {
        TableModel<Test> testTableModel = new TableModel<>(
                new String[]{"Test Date", "Symptoms", "Status", "Patient ID"},
                "Tests",
                testService.getTests()
        );

        model.addAttribute("tableModel", testTableModel);
        return "test-list";
    }

    @GetMapping("/test/new")
    public String newTest(Model model){
        model.addAttribute("test", new Test());
        return "new-test";
    }

    @PostMapping("/test/new")
    public String saveTest (@Valid Test test, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("test", test);
            return "new-test";
        }

        testService.addTest(test);
        return "redirect:/";
    }

    @GetMapping("/editTest/{id}")
    public String getEditTest(@PathVariable String id, Model model){
        Test test = testService.getTest(Integer.parseInt(id));

        if (test != null) {
            model.addAttribute("test", test);
            model.addAttribute("update", true);
            return "new-test";
        }

        return "redirect:/";
    }

    @PostMapping("/editTest/{id}")
    public String editTest(@PathVariable int id, @Valid Test test, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("update", true);
            test.setTestId(id);
            model.addAttribute("test", test);
            return "new-test";
        }

        test.setTestId(id);
        testService.updateTest(test);
        return "redirect:/";
    }

    @PostMapping("/deleteTest/{id}")
    public String deleteTest(@PathVariable String id){
        testService.deleteTest(Integer.parseInt(id));
        return "redirect:/";
    }
}
