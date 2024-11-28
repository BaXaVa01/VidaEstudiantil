package com.registify.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Estudiante_entity extends Identifiable{

    @Column(name = "apellido", unique = true)
    private String apellido;

    @Column(name = "cif", unique = true )
    private String cif;

    @Column(name = "nombre", unique = true)
    private String nombre ;

    @Column(name = "correo", unique = true )
    private String Correo;

}
