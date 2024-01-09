package com.example.demo.controller;

import com.example.demo.dao.PatientDao;
import com.example.demo.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/paciente")
public class SampleController {

    @Autowired
    SampleService sampleService;

    @PostMapping("/guardar")
    public void savePatient(@RequestBody PatientDao patientDao){
        sampleService.savePatient(patientDao);
    }
}
