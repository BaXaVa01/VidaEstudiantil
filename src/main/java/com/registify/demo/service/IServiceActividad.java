package com.registify.demo.service;

import com.registify.demo.model.Actividad_entity;

import java.util.List;
import java.util.UUID;

public interface IServiceActividad {
    List<Actividad_entity> getActividades();

    void saveActividad(Actividad_entity actividad);

    void deleteActividad(UUID id);

    Actividad_entity update(Actividad_entity actividad);

    Actividad_entity getActividad(UUID id);



}


