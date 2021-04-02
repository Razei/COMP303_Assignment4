package com.spring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestService {
    //create a test hashmap
    Map<Integer, Test> test = new HashMap<>();

	@Autowired
	private TestRepository testRepository;

    public void addTest(Test t){
		testRepository.save(t);
    }

    //return the test hashmap
    public List<Test> getTests() {
        return testRepository.findAll();
    }

    //get a specific test
    public Test getTest(int testId) {
		return testRepository.findById(testId).orElse(null);
    }

    //test for a specific patient
    public List<Test> getPatientTests(int patId) {
        return testRepository.findTestsByPatientId(patId);
    }

    //update test
    public void updateTest(Test t){
		Test test = testRepository.findById(t.getTestId()).orElse(null);

		if (test != null) {
			testRepository.save(t);
		}
    }

    //delete test
    public void deleteTest(int testId) {
		Test test = testRepository.findById(testId).orElse(null);

		if (test != null) {
			testRepository.deleteById(testId);
		}
    }
}
