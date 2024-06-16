package org.example.demospringbootapi.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.demospringbootapi.entities.PlayerEntity;
import org.example.demospringbootapi.models.Player;
import org.example.demospringbootapi.repositories.jpa.PlayerJpaRepository;
import org.example.demospringbootapi.services.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerJpaRepository playerJpaRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Player getPlayerById(Long id) {
        PlayerEntity playerEntity = playerJpaRepository.getReferenceById(id);
        if (Objects.isNull(playerEntity.getUserName())){
            throw new EntityNotFoundException();
        }
        Player player = modelMapper.map(playerEntity, Player.class);
        return player;
    }

    @Override
    public Player savePlayer(Player player) {
        //TODO: JpaRepository Busqueda a la base de datos
        //Con esto fuimos a la base de datos y validamos si nos devolvio o no un valor..
        Optional<PlayerEntity> playerEntityOptional = playerJpaRepository.findByUserNameOrEmail(
                player.getUserName(), player.getEmail()
        );
        if (playerEntityOptional.isEmpty()){
            PlayerEntity playerEntity = modelMapper.map(player, PlayerEntity.class);
            PlayerEntity playerEntitySaved = playerJpaRepository.save(playerEntity);
            return modelMapper.map(playerEntitySaved, Player.class);
        }else {
            return null;
        }

    }
}
