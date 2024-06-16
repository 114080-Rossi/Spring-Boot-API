package org.example.demospringbootapi.repositories.jpa;

import org.example.demospringbootapi.entities.PlayerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PlayerJpaRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PlayerJpaRepository playerJpaRepository;


    //TODO: TEST JpaRepository
    @Test
    public void findByUserNameOrEmailTest(){
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setEmail("email@email.com");
        playerEntity.setUserName("username");
        playerEntity.setPassword("Password431!");

        entityManager.persist(playerEntity);
        entityManager.flush();

        Optional<PlayerEntity> result = playerJpaRepository.findByUserNameOrEmail("username", "email@email.com");
        assertEquals("username", result.get().getUserName());
    }
}