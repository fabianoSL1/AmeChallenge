package com.fabianosl.amechallenge.swapi;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class SWapiServiceTest {

    @Autowired
    private SWapiService swapiService;

    @Test
    public void givenFive_when_Tatooine() {
        var count = swapiService.countFilmsByPlanetName("Tatooine");

        assertEquals(5, count);
    }

    @Test
    public void throwNoSuchElementException_when_PlanetNotExist() {
        assertThrows(NoSuchElementException.class, () -> swapiService.countFilmsByPlanetName("random"));
    }
}
