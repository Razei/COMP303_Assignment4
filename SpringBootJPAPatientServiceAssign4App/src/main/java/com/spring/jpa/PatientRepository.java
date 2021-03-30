package com.spring.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query("SELECT patient FROM Patient patient WHERE patient.ohip_ID = :ohip_id")
    Patient findPatientByOhip_ID(@Param("ohip_id") Integer ohip_id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Patient patient WHERE patient.ohip_ID = :ohip_id")
    void deletePatientByOhip_ID(@Param("ohip_id") Integer ohip_id);
}
