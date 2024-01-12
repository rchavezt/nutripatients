package com.example.demo.controller;

import com.example.demo.dao.PatientDao;
import com.example.demo.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController("/paciente")
public class SampleController {

    @Autowired
    SampleService sampleService;

    @PostMapping("/guardar")
    public void savePatient(@RequestBody PatientDao patientDao){
        sampleService.savePatient(patientDao);
    }

    @GetMapping("/buscar")
    public String searchPatient(@RequestParam Integer id){
        return sampleService.getPatient(id);
    }

    @DeleteMapping
    public String deletePatient(@RequestParam Integer id){
        return sampleService.deletePatient(id);
    }

    @GetMapping("/verTodos")
    public ResponseEntity<List<PatientDao>> listAllPatient(){
        return ResponseEntity.ok(sampleService.listAllPatient());
    }
}
