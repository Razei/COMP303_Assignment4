package com.spring.jpa;

import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	//create a test hashmap
	Map<Integer, Test> test = new HashMap<>();
	
	 public void addTest(Test t) throws Exception {
	        if(test.containsKey(t.getTestId())) {
	            throw new Exception("A Test already exists with this ID");
	        }
	        else {
	           test.put(t.getTestId(), t);
	        }
	    }
	 
	 //return the test hashmap
	 public Iterable<Test> getTests(){
	        return test.values();
	    }
	 //get a specific test
	  public Test getTest(int testId) throws Exception {

	        if(test.containsKey(testId)) {
	            return test.get(testId);
	        }
	        else {
	            throw new Exception("Test Id not found");
	        }
	    }
	  
	  //test for a specific patient
	  public List<Test> getPatientTests(int OHIP_NUM){
		  List<Test> unfilteredList=  new ArrayList<Test>( test.values());
		  List<Test> filteredList = new ArrayList<Test>();
		  for(Test t: unfilteredList) {
			  if(t.getPatient_id() == OHIP_NUM) {
				  filteredList.add(t);
			  }
		  }
		  
		  return filteredList;
		  
	  }
	  //update test
	  public void updateTest(Test t) throws Exception {
	        if(test.containsKey(t.getTestId())) {
	            test.put(t.getTestId(), t);
	        }
	        else {
	            throw new Exception("Test Id not found");
	        }
	    }
	  
	  //delete test
	  public void deleteTest(int testId) throws Exception {
	        if(test.containsKey(testId)) {
	            test.remove(testId);
	        }
	        else {
	            throw new Exception("test Id not found");
	        }
	    }
}
