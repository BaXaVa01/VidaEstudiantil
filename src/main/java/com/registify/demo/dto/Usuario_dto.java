package com.registify.demo.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario_dto {

    private String cif;

    private String password;
}
