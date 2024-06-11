package org.example.demospringbootapi.services;


import org.example.demospringbootapi.models.Player;
import org.springframework.stereotype.Service;

@Service
public interface PlayerService {

    Player getPlayerById(Long id);
}
