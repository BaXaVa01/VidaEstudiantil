package com.registify.demo.service;

import com.registify.demo.model.Actividad_entity;
import com.registify.demo.repository.IActividadRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceActividad_impl implements IServiceActividad {

    @Autowired
    private IActividadRepo actividad;


    @Override
    public List<Actividad_entity> getActividades() {
        return actividad.findAll();
    }

    @Override
    public void saveActividad(Actividad_entity actividadS) {
        actividad.save(actividadS);
    }

    @Override
    public void deleteActividad(UUID id ) {
        actividad.deleteById(id);
    }

    @Override
    public Actividad_entity update(Actividad_entity actividadS) {
        return actividad.save(actividadS);
    }

    @Override
    public Actividad_entity getActividad(UUID id) {
        return actividad.findById(id).get();
    }
}
