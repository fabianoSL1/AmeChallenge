package com.fabianosl.amechallenge.planet;

import com.fabianosl.amechallenge.planet.dto.CreatePlanetDTO;
import com.fabianosl.amechallenge.swapi.SWapiService;
import jakarta.inject.Inject;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@Log4j2
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PlanetServiceTest {

    @Autowired
    private PlanetService planetService;

    @MockBean
    private SWapiService swapiService;

    @Inject
    private PlanetRepository planetRepository;


    @BeforeEach
    public void setUp() {
        planetRepository.deleteAll();
    }

    @Test
    void givenPlanetNameNotInSWApi_whenCreatePlanet_thenCreateWithoutFilms() {
        Mockito.when(swapiService.countFilmsByPlanetName(Mockito.anyString())).thenThrow(NoSuchElementException.class);

        var planet = planetService.createPlanet(createPlanetDTO());

        assertNotNull(planet.getId());
        assertEquals(planet.getFilms(), 0);
    }

    @Test
    void givenPlanetNameInSWApi_whenCreatePlanet_thenCreateWithFilms() {
        int expected = 2;

        Mockito.when(swapiService.countFilmsByPlanetName(Mockito.anyString())).thenReturn(expected);

        var planet = planetService.createPlanet(createPlanetDTO());

        assertNotNull(planet.getId());
        assertEquals(planet.getFilms(), expected);
    }

    private CreatePlanetDTO createPlanetDTO() {
        return CreatePlanetDTO.builder()
                .name("random")
                .weather("random")
                .terrain("random")
                .build();
    }

}
