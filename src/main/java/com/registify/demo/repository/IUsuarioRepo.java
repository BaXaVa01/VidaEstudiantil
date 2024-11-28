package com.registify.demo.repository;

import com.registify.demo.model.Actividad_entity;
import com.registify.demo.model.Usuario_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario_entity, UUID> {

    Optional<Usuario_entity> findByCif(Integer cif);
}
