package com.example.demo.service;

import com.example.demo.dao.PacienteDao;
import com.example.demo.dto.PatientDto;
import com.example.demo.entity.PacienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SampleService {
    String status = "";
    PacienteEntity aux;
    PatientDto auxP;

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

    public PatientDto getPatientById(Long id){
        var pacienteDto = new PatientDto();
        PacienteEntity patient = pacienteDao.findById(id).orElse(null);

        if (patient == null) {
            status = "No se encontro el usuario";
            throw new RuntimeException(status);
        }else {
            status = "";
            pacienteDto.setNombre(patient.getNombre());
            pacienteDto.setApellido(patient.getApellido());
            pacienteDto.setEdad(patient.getEdad());
        }
        return pacienteDto;
    }

    public List<PatientDto> getPatientByApellido(String apellido){
        List<PatientDto> pacientes = new ArrayList<>();
        List<PacienteEntity> pacienteEntityList = pacienteDao.findByApellido(apellido);
        System.out.println("Lista de pacientes: "+ pacienteEntityList.size());
        for (int i = 0; i<pacienteEntityList.size(); i++){
            aux = pacienteEntityList.get(i);
            auxP = new PatientDto();
            auxP.setNombre(aux.getNombre());
            auxP.setApellido(aux.getApellido());
            auxP.setEdad(aux.getEdad());
            pacientes.add(i, auxP);
        }
        return pacientes;
    }

    public String delete(Long id, String nombre){
        if (status.isEmpty()){
            pacienteDao.deleteById(id);
            status = "Paciente" + nombre +" con id: " +id+ " ha sido eliminado";
        }
        System.out.println(status);
        return status;
    }

    public List<PatientDto> listAllPatient(){
        List<PatientDto> pacientes = new ArrayList<>();
        List<PacienteEntity> pacienteEntityList = (List<PacienteEntity>) pacienteDao.findAll();
        for (int i = 0; i<pacienteEntityList.size(); i++){
            aux = pacienteEntityList.get(i);
            auxP = new PatientDto();
            auxP.setNombre(aux.getNombre());
            auxP.setApellido(aux.getApellido());
            auxP.setEdad(aux.getEdad());
            pacientes.add(i, auxP);
        }
        return pacientes;
    }
}
