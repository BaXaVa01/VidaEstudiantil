package com.registify.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apisaludos")
public class Saludo_Controller {

    @GetMapping("/hola")
    public String holaMundo(){
        return "Hola Mundo";
    }
}
