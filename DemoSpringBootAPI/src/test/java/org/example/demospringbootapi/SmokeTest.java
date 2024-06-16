package org.example.demospringbootapi;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.demospringbootapi.controllers.PingController;
import org.example.demospringbootapi.controllers.PlayerController;
import org.example.demospringbootapi.services.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//TODO: SpringBootTest
/**
 Como le estamos diciendo que es un springBootTest va a levantar el contexto, luego le va a pedir que le de playerController y va a validar que no sea luno.
 Va a validar que levante correctamente.
 Esto valida que nuestro conexto levanta correctamente
 */
@SpringBootTest
public class SmokeTest {
    //TODO: smoke test rapido
    @Autowired
    private PlayerController playerController;

    @Autowired
    private PingController pingController;

    @Autowired
    private PlayerService playerService;

    @Test
    public void contextLLoads() throws Exception{
        assertThat(playerController).isNull();
        assertThat(pingController).isNull();
        assertThat(playerService).isNull();
    }
}
