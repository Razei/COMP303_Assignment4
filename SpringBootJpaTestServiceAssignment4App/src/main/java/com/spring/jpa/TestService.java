package com.spring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TestService {
    //create a test hashmap
    Map<Integer, Test> test = new HashMap<>();

	@Autowired
	private TestRepository testRepository;

    public Test addTest(Test t){
		return testRepository.save(t);
		/*
		if (test.containsKey(t.getTestId())) {
            throw new Exception("A Test already exists with this ID");
        } else {
            test.put(t.getTestId(), t);
        }*/
    }

    //return the test hashmap
    public List<Test> getTests() {
        return testRepository.findAll();
    }

    //get a specific test
    public Test getTest(int testId) {
		return testRepository.findById(testId).orElse(null);
        /*if (test.containsKey(testId)) {
            return test.get(testId);
        } else {
            throw new Exception("Test Id not found");
        }*/
    }

    //test for a specific patient
    public List<Test> getPatientTests(int OHIP_NUM) {
        return testRepository.findTestsByPatientId(OHIP_NUM);

        /*List<Test> unfilteredList = new ArrayList<Test>(test.values());
        List<Test> filteredList = new ArrayList<Test>();
        for (Test t : unfilteredList) {
            if (t.getPatient_id() == OHIP_NUM) {
                filteredList.add(t);
            }
        }

        return filteredList;*/

    }

    //update test
    public String updateTest(Test t) {
		Test test = testRepository.findById(t.getTestId()).orElse(null);

		if (test != null) {
			testRepository.save(t);
			return "Updated " + test.getTestId();
		} else {
			return "Not found";
		}

        /*if (test.containsKey(t.getTestId())) {
            test.put(t.getTestId(), t);
        } else {
            throw new Exception("Test Id not found");
        }*/
    }

    //delete test
    public String deleteTest(int testId) throws Exception {
		Test test = testRepository.findById(testId).orElse(null);

		if (test != null) {
			testRepository.deleteById(testId);
			return "Deleted " + test.getTestId();
		} else {
			return "Not found";
		}

        /*if (test.containsKey(testId)) {
            test.remove(testId);
        } else {
            throw new Exception("test Id not found");
        }*/
    }
}
