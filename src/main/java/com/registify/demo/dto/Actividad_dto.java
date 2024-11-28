package com.registify.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Actividad_dto {
    private UUID id;
    private String nombre;
    private String descripcion;
    private Integer cupo;
    private Date fecha;
}
