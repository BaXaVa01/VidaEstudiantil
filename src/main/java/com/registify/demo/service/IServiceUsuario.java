package com.registify.demo.service;

import com.registify.demo.dto.Usuario_dto;
import com.registify.demo.model.Actividad_entity;
import com.registify.demo.model.Usuario_entity;

import java.util.List;
import java.util.UUID;

public interface IServiceUsuario {
    List<Usuario_entity> getUsuario();

    void saveUsuario(Usuario_dto actividad)  throws Exception;

    void deleteUsuario(UUID id);

    void update(Usuario_entity usuarioP);

    Usuario_entity getUsuario(UUID id);

    Boolean confirmCredentials(Usuario_dto usuarioP) throws Exception;
}
