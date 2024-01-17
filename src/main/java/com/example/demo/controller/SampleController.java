package com.example.demo.controller;

import com.example.demo.dto.PatientDto;
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
    public void savePatient(@RequestBody PatientDto patient){
        sampleService.savePatient(patient);
    }

    @GetMapping("/buscar/{apellido}")
    public PatientDto searchPatient(@PathVariable String apellido){
        return sampleService.getPatientByApellido(apellido);
    }

    @DeleteMapping
    public String deletePatient(@RequestParam Integer id){
        return sampleService.deletePatient(id);
    }

    @GetMapping("/verTodos")
    public ResponseEntity<List<PatientDto>> listAllPatient(){
        return ResponseEntity.ok(sampleService.listAllPatient());
    }
}
