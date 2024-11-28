package com.registify.demo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@Entity
@Getter
@Setter
public class Actividad_entity extends Identifiable {

    @Column(name = "nombreActividad", nullable = false)
    private String nombreActividad;

    @Column(name = "cupo", nullable = false)
    private Integer cupo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "horaFin")
    private Time horaFin;


}
