package com.example.demo.service;

import com.example.demo.dao.PacienteDao;
import com.example.demo.dto.PatientDto;
import com.example.demo.entity.PacienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SampleService {
    String status;

    @Autowired
    PacienteDao pacienteDao;
    public void savePatient(PatientDto patient) {
        PacienteEntity pacienteEntity = new PacienteEntity();
        pacienteEntity.setNombre(patient.getNombre());
        pacienteEntity.setApellido(patient.getApellido());
        pacienteEntity.setEdad(patient.getEdad());
        pacienteEntity = pacienteDao.save(pacienteEntity);

        System.out.println("Paciente registrado con ID: " + pacienteEntity.getId());
    }

    public PatientDto getPatientByApellido(String apellido){
        List<PacienteEntity> pacienteEntityList = pacienteDao.findByApellido(apellido);
        var paciente = pacienteEntityList.get(0);
        var pacienteDto = new PatientDto();
        pacienteDto.setNombre(paciente.getNombre());
        pacienteDto.setApellido(paciente.getApellido());
        pacienteDto.setEdad(paciente.getEdad());

        return pacienteDto;
    }

    public String deletePatient(Integer id){
        /*if(pacientes.containsKey(id)){
            status = "Paciente "+ pacientes.get(id).getNombre() + " eliminado";
            pacientes.remove(id);
            System.out.println(status);
        }else{
            status = "No existe el paciente";
            System.out.println(status);
        }*/
        return status;
    }

    public List<PatientDto> listAllPatient(){
        return null;
    }
}
