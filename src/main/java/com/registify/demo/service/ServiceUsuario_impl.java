package com.registify.demo.service;

import com.registify.demo.dto.Usuario_dto;
import com.registify.demo.model.Usuario_entity;
import com.registify.demo.repository.IUsuarioRepo;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceUsuario_impl implements IServiceUsuario{

    @Autowired
    private IUsuarioRepo usuarioRepo;


    @Override
    public List<Usuario_entity> getUsuario() {
        return usuarioRepo.findAll();
    }

    @Override
    public void saveUsuario(Usuario_dto user) throws Exception {
        try{

            if(usuarioRepo.findByCif(user.getCif()).isPresent()){
                throw new Exception("Usuario ya creado");
            }

            Usuario_entity usuario = new Usuario_entity();
            usuario.setCif(user.getCif());
            usuario.setPassword(user.getPassword());



            usuarioRepo.save(usuario);
        } catch (Exception e) {
            throw e;
        }


    }

    @Override
    public void deleteUsuario(UUID id) {
        usuarioRepo.deleteById(id);
    }

    @Override
    public void update(Usuario_entity usuarioP) {
        usuarioRepo.save(usuarioP);
    }

    @Override
    public Usuario_entity getUsuario(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<String> confirmCredentials(Usuario_dto usuarioP) throws Exception {

        try {
            // Buscar usuario por CIF
            Usuario_entity usuario = usuarioRepo.findByCif(usuarioP.getCif()).orElse(null);

            if (usuario == null) {
                // Usuario no encontrado, retorna 404
                return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
            }

            // Verificar que las contraseñas coincidan
            if (usuarioP.getPassword().equals(usuario.getPassword())) {
                // Credenciales correctas, retorna 200 OK
                return new ResponseEntity<>("Login exitoso", HttpStatus.OK);
            } else {
                // Contraseña incorrecta, retorna 401
                return new ResponseEntity<>("Contraseña incorrecta", HttpStatus.UNAUTHORIZED);
            }

        } catch (Exception e) {
            // En caso de error general, devuelve 500
            return new ResponseEntity<>("Error en el servidor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
