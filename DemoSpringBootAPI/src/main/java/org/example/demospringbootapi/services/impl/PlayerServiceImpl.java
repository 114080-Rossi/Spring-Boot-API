package org.example.demospringbootapi.services.impl;

import org.example.demospringbootapi.entities.PlayerEntity;
import org.example.demospringbootapi.models.Player;
import org.example.demospringbootapi.repositories.jpa.PlayerJpaRepository;
import org.example.demospringbootapi.services.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerJpaRepository playerJpaRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Player getPlayerById(Long id) {
        PlayerEntity playerEntity = playerJpaRepository.getReferenceById(id);
        Player player = modelMapper.map(playerEntity, Player.class);
        return player;
    }
}
