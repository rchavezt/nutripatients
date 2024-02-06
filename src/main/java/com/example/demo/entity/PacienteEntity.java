package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "patients")
public class PacienteEntity {
    @Id
    @Column(name = "id_patient")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @Column(name = "nombre")
    String nombre;
    @Column(name = "apellido")
    String apellido;
    @Column(name = "edad")
    Integer edad;
}
