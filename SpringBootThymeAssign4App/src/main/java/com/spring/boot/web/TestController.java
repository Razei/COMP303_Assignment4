package com.spring.boot.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.boot.model.Test;
import com.spring.boot.model.TableModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class TestController {
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Test> localTests;
    private final String apiURL = "http://desktop-15eve81:8083";

    @GetMapping("/tests")
    public String getTests(Model model) throws JsonProcessingException {
        final String uri = apiURL + "/tests";
        RestTemplate restTemplate = new RestTemplate();
        String jsonTests = restTemplate.getForObject(uri, String.class);

        List<Test> tests = Arrays.asList(mapper.readValue(jsonTests, Test[].class));
        localTests = tests;

        TableModel<Test> testTableModel = new TableModel<>(
                new String[]{"Test Date", "Symptoms", "Status", "Patient ID"},
                "Tests",
                tests
        );

        model.addAttribute("tableModel", testTableModel);
        return "test/test-list";
    }

    @GetMapping("/test/new")
    public String newTest(){
        return "test/new-test";
    }

    @PostMapping("/test/new")
    public String saveTest (@ModelAttribute Test test){
        RestTemplate restTemplate = new RestTemplate();
        final String uri = apiURL + "/test/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        test.setId(0);
        HttpEntity<Test> request = new HttpEntity<>(test, headers);

        restTemplate.postForObject(uri, request, Test.class);
        return "redirect:/tests";
    }

    @GetMapping("/editTest/{id}")
    public String getEditTest(@PathVariable String id, Model model){
        if (localTests != null) {
            Test test = localTests.stream()
                    .filter(p -> p.getTestId() == Long.parseLong(id))
                    .findAny()
                    .orElse(null);

            if (test != null) {
                model.addAttribute("test", test);
                return "test/new-test";
            }
        }

        return "redirect:/tests";
    }

    @PostMapping("/editTest/{id}")
    public String editTest(@ModelAttribute Test test, @PathVariable String id){
        RestTemplate restTemplate = new RestTemplate();
        final String uri = apiURL + "/test/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        test.setId(Integer.valueOf(id));
        HttpEntity<Test> request = new HttpEntity<>(test, headers);

        restTemplate.put(uri, request, Test.class);

        return "redirect:/tests";
    }

    @PostMapping("/deleteTest/{id}")
    public String deleteTest(@PathVariable String id){
        final String uri = apiURL + "/test/" + id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri);
        return "redirect:/tests";
    }
}
