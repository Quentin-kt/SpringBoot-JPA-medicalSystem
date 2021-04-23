package com.hospital.medicalsystem.repository;

import com.hospital.medicalsystem.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByIdCardLikeOrNameLike(String idCard,String name);
}
