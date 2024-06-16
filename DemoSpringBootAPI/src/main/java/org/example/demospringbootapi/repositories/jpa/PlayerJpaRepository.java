package org.example.demospringbootapi.repositories.jpa;

import org.example.demospringbootapi.entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerJpaRepository extends JpaRepository<PlayerEntity, Long> {

    //TODO: JpaRepository Busqueda a la base de datos
    /** Solo con esto el jpa va a saber que tiene que buscar sobre los campos usernamee y email**/
    Optional<PlayerEntity> findByUserNameOrEmail(String username,String email);

}
