package com.spring.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/test/{testId}", method = RequestMethod.GET)
    Test getTest(@PathVariable("testId") int testId) throws Exception {
        return testService.getTest(testId);
    }

    @RequestMapping(value = "/tests", method = RequestMethod.GET)
    List<Test> getTests() {
        return testService.getTests();
    }

    @RequestMapping(value = "/test/patient/{patient_id}", method = RequestMethod.GET)
    List<Test> getPatientTest(@PathVariable("patient_id") int patient_id) throws Exception {
        return testService.getPatientTests(patient_id);
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    Test addTest(@RequestBody @Valid Test t) throws Exception {
        return testService.addTest(t);
    }

    @RequestMapping(value = "/test/{testId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    String updateTest(@PathVariable("testId") int testId, @RequestBody Test t) throws Exception {
        t.setTestId(testId);
        return testService.updateTest(t);
    }

    @RequestMapping(value = "/test/{testId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    String deleteTest(@PathVariable("testId") int testId) throws Exception {
        return testService.deleteTest(testId);
    }
}
