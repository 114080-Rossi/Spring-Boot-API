package org.example.demospringbootapi.controllers;

import org.springframework.web.bind.annotation.GetMapping; //Verificar que nuestro paquetes pom.xml esten escritos correctamente
import org.springframework.web.bind.annotation.RestController;

@RestController //Es una API de tipo REST
public class PingController {

    @GetMapping("/ping") //Un mapeo al verbo get
    public String pong(){
        return "pong";
    }
    //Aca tendriamos nuestro primer controlador que nos permite verificar el estado de salud del sitio
}
