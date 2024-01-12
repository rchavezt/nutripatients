package com.example.demo.service;

import com.example.demo.dao.PatientDao;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SampleService {
    String status;
    Map<Integer, PatientDao> pacientes = new HashMap<>();
    List<PatientDao> patientDaoList =new ArrayList<>();
    public void savePatient(PatientDao patient) {
        pacientes.put(pacientes.size() + 1, patient);
        System.out.println("Paciente registrado: " + patient.getNombre());
    }

    public String getPatient(Integer id){
        return pacientes.get(id).getNombre();
    }

    public String deletePatient(Integer id){
        if(pacientes.containsKey(id)){
            status = "Paciente "+ pacientes.get(id).getNombre() + " eliminado";
            pacientes.remove(id);
            System.out.println(status);
        }else{
            status = "No existe el paciente";
            System.out.println(status);
        }
        return status;
    }

    public List<PatientDao> listAllPatient(){
        return new ArrayList<>(pacientes.values());
    }
}
