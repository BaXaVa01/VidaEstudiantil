package com.registify.demo.controller;


import com.registify.demo.dto.Usuario_dto;
import com.registify.demo.model.Actividad_entity;
import com.registify.demo.model.Usuario_entity;
import com.registify.demo.service.IServiceActividad;
import com.registify.demo.service.IServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/login")
public class ControllerLogin {
    @Autowired
    private IServiceUsuario service;

    @GetMapping("/hola")
    public String holaMundo(){
        return "Hola Mundo";
    }

    @PostMapping("/post")
    public void saveUser(@RequestBody Usuario_dto usuario) {

        try{
            service.saveUsuario(usuario);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    @CrossOrigin(origins = "http://localhost:5180")
    @PostMapping("/log")
    public ResponseEntity<String> loginUser(@RequestBody Usuario_dto usuarioDto) {
        try {
            // Llamada al servicio para verificar las credenciales
            return service.confirmCredentials(usuarioDto);

        } catch (Exception e) {
            e.printStackTrace();
            // En caso de error, retornamos un mensaje de error con código 500
            return new ResponseEntity<>("Error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getall")
    public List<Usuario_entity> getAll(){
        return service.getUsuario();
    }
}
