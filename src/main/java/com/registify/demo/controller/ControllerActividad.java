package com.registify.demo.controller;


import com.registify.demo.model.Actividad_entity;
import com.registify.demo.repository.IActividadRepo;
import com.registify.demo.service.IServiceActividad;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actividad")
public class ControllerActividad {
    @Autowired
    private IServiceActividad service;

    @GetMapping("/get")
    public List<Actividad_entity> getAll() {
        return service.getActividades();
    }

    @PostMapping("/create")
    public void createActividad(@RequestBody Actividad_entity actividad) {
        service.saveActividad(actividad);
    }
    @GetMapping("/hola")
    public String holaMundo(){
        return "Hola Mundo";
    }
}
