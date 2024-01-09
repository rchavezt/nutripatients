package com.example.demo.service;

import com.example.demo.dao.PatientDao;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SampleService {
    Map<Integer, PatientDao> pacientes = new HashMap<>();
    public void savePatient(PatientDao patient) {
        pacientes.put(pacientes.size() + 1, patient);
        System.out.println("Paciente registrado: " + patient.getNombre());
    }
}
