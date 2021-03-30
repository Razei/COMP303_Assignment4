package com.spring.jpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Integer>{
    @Query("SELECT test FROM Test test WHERE test.patient_id = :ohip_id")
    List<Test> findTestsByPatientId(@Param("ohip_id") Integer ohip_id);
}
