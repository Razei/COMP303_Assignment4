package com.spring.jpa;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {
	
	@Autowired
	TestService testService;
	
	 @RequestMapping(value = "/test/{testId}", method = RequestMethod.GET)
	 Test getTest(@PathVariable("testId") int testId) throws Exception {
	     return testService.getTest(testId);
	 }
	 
	 @RequestMapping(value = "/tests", method = RequestMethod.GET)
	 Iterable<Test> getTests() {
	     return testService.getTests();
	 }
	 
	 @RequestMapping(value = "/test/patient/{patient_id}", method = RequestMethod.GET)
	 List<Test> getPatientTest(@PathVariable("patient_id") int patient_id) throws Exception {
	     return testService.getPatientTests(patient_id);
	 }
	 
	 
	 @RequestMapping(value = "/test", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseStatus(value = HttpStatus.OK)
	 void addTest(@RequestBody Test t) throws Exception {
	     testService.addTest(t);
	 }
	 
	 @RequestMapping(value = "/test/{testId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseStatus(value = HttpStatus.OK)
	 void updateTest(@PathVariable("testId") int testId, @RequestBody Test t) throws Exception {
	     t.setTestId(testId);
	    testService.updateTest(t);
	 }
	 
	 @RequestMapping(value = "/test/{testId}", method = RequestMethod.DELETE)
	 @ResponseStatus(value = HttpStatus.OK)
	 void deleteTest(@PathVariable("testId") int testId) throws Exception {
	     testService.deleteTest(testId);
	 }

}
