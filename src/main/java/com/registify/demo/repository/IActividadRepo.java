package com.registify.demo.repository;

import com.registify.demo.model.Actividad_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IActividadRepo extends JpaRepository<Actividad_entity, UUID> {
}
