package com.registify.demo.service;

import com.registify.demo.dto.TokenResponse;
import com.registify.demo.dto.Usuario_dto;
import com.registify.demo.model.Usuario_entity;
import com.registify.demo.repository.IUsuarioRepo;
import io.swagger.v3.core.util.Json;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

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

//    @Override
//    public Boolean confirmCredentials(Usuario_dto usuarioP) throws Exception {
//
//        try {
//            Usuario_entity usuario = usuarioRepo.findByCif(usuarioP.getCif()).get();
//            if (usuario == null) {
//                throw new Exception("Usuario no encontrado");
//            }
//
//            if (usuarioP.getPassword() == usuario.getPassword()) {
//                return true;
//            }
//
//        } catch (Exception e) {
//            throw e;
//        }
//
//        return false;
//    }

    @Override
    public String confirmCredentials(Usuario_dto usuarioP) throws Exception {
        RestClient restClient = RestClient.builder().build();

        try{
            ResponseEntity<String> token = restClient.post()
                    .uri("https://uvirtual.uam.edu.ni:442/uambiblioapi/User/login")
                    .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                    .body(usuarioP)
                    .retrieve().toEntity(String.class);

            System.out.println(token.getBody());



            // Realizar la solicitud GET
            String url = "https://uvirtual.uam.edu.ni:442/uambiblioapi/User/GetStudentInformation?cif=" + usuarioP.getCif();
            ResponseEntity<String> respuseta = restClient.get()
                    .uri()
                    .header("Authorization", "Bearer " +token.getBody())
                    .retrieve()
                    .toEntity(String.class);


//            System.out.println(datosEstudiante.getBody());
            return respuseta.getBody();

        }
        catch (Exception e){

            throw e;
        }


    }

}
