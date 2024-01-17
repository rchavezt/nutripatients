package com.example.demo.dao;

import com.example.demo.entity.PacienteEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PacienteDao extends CrudRepository<PacienteEntity, Long> {
    List<PacienteEntity> findByApellido(String apellido);
}
