package org.example.demospringbootapi.repositories.jpa;

import org.example.demospringbootapi.entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerJpaRepository extends JpaRepository<PlayerEntity, Long> {

}
