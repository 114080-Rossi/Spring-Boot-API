package org.example.demospringbootapi.controllers;

import org.example.demospringbootapi.models.Player;
import org.example.demospringbootapi.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping("/{id}")
    public ResponseEntity<Player> getById(@PathVariable Long id){
        Player player = playerService.getPlayerById(id);
        return ResponseEntity.ok(player);
    }

    @PostMapping("")
    public ResponseEntity<Player> savePlayer(@RequestBody @Valid Player player){
        return ResponseEntity.ok(playerService.savePlayer(player));
    }
}
