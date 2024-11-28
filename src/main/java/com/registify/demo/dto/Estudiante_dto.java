package com.registify.demo.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Estudiante_dto {
    private UUID id;
    private String apellido;

    private String cif;

    private String nombre ;

}
