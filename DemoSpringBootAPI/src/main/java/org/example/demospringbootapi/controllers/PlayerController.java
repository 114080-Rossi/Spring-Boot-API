package org.example.demospringbootapi.controllers;

import org.example.demospringbootapi.entities.PlayerEntity;
import org.example.demospringbootapi.models.Player;
import org.example.demospringbootapi.repositories.jpa.PlayerJpaRepository;
import org.example.demospringbootapi.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;



    //public player getPlayerJpaRepository PlayerJpaRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Player> getById(@PathVariable Long id){
        Player player = playerService.getPlayerById(id);
        return ResponseEntity.ok(player);
    }
}
