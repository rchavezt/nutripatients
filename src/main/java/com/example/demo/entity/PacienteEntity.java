package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PacienteEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    String nombre;
    String apellido;
    Integer edad;
}
