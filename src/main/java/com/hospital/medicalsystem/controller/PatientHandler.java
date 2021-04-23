package com.hospital.medicalsystem.controller;

import com.hospital.medicalsystem.entity.*;
import com.hospital.medicalsystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientHandler {
    @Autowired
    private PatientRepository patientRepository;

    //接口3：挂号接口/修改信息接口
    @PostMapping("/register")
    public Result register(@RequestBody Patient patient) {
        Patient responseList = patientRepository.save(patient);
        //装配result
        Result result = new Result();

        if ("1".equals(patient.getState())) {
            result.setCode(1);
            result.setMsg("挂号成功");
        }else {
            result.setCode(-1);
            result.setMsg("退号成功");
        }
        result.setData(patient);
        return result;
    }

    //接口4：患者信息查询，支持模糊查询
    @PostMapping("/query")
    public Result query(@RequestParam("key") String key) {
        List<Patient> patients;
        Result result = new Result();
        if (key.isEmpty()) {
            patients = patientRepository.findAll();
        } else {
            patients = patientRepository.findByIdCardLikeOrNameLike(
                    "%" + key + "%", "%" + key + "%");
        }
        result.setData(patients);
        result.setCode(1);
        result.setMsg("查询成功");
        return result;
    }

}
