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
    public ResponseEntity<List<PatientDto>> searchPatient(@PathVariable String apellido){
        return ResponseEntity.ok(sampleService.getPatientByApellido(apellido));
    }

    @GetMapping("/buscarPaciente")
    public PatientDto searchPatientById(@RequestParam Long id){
        return sampleService.getPatientById(id);
    }

    @DeleteMapping("/paciente")
    public String deletePatient(@RequestParam Long id){
        PatientDto pacienteEntity = sampleService.getPatientById(id);
        return sampleService.delete(id, pacienteEntity.getNombre());
    }

    @GetMapping("/verPacientes")
    public ResponseEntity<List<PatientDto>> listAllPatient(){
        return ResponseEntity.ok(sampleService.listAllPatient());
    }
}
