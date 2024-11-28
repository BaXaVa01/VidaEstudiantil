package com.registify.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario_entity extends Identifiable {

    @Column(name = "usuario")
    private String cif;

    @Column(name = "password")
    private String password;
}
