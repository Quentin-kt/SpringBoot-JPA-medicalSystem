package com.hospital.medicalsystem.repository;

import com.hospital.medicalsystem.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PatientRepositoryTest {
    @Autowired
    private PatientRepository patientRepository;

    @Test
    void findAll() {
        System.out.println(patientRepository.findAll());
    }

    /**
     *患者挂号 测试
     */
    @Test
    void register() {
        //注册用户并返回patientId
        Patient patient = new Patient();
        patient.setIdCard("123");
        patient.setIdType("1");
        patient.setName("hkt");
        patient.setSocialSecurityNo("socialSecurityNo");
        patient.setState("2");
        patientRepository.save(patient);
        System.out.println(patient);
    }
}