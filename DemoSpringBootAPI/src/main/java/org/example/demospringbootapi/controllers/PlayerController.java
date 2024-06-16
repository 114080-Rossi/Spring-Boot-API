package org.example.demospringbootapi.controllers;

import jakarta.validation.Valid;
import org.example.demospringbootapi.models.Player;
import org.example.demospringbootapi.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

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
        //TODO: JpaRepository Busqueda a la base de datos
        Player playerSaved = playerService.savePlayer(player);
        if (Objects.isNull(playerSaved)){ //Esto es lo mismo que playerSaved == null
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usarname or email already exist");
        }else {
            return ResponseEntity.ok(playerSaved);
        }
    }
}
