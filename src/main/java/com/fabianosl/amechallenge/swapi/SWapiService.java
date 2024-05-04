package com.fabianosl.amechallenge.swapi;

import com.fabianosl.amechallenge.swapi.dto.Planet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SWapiService {

    private final SWapiClient swapiClient;

    public int countFilmsByPlanetName(String name) {
        var planet = getPlanet(name);
        return planet.getFilms().size();
    }

    private Planet getPlanet(String name) {
        var response = swapiClient.getPlanetByName(name);

        var planet = response.getResults()
                .stream()
                .filter(item -> item.getName().equals(name))
                .findFirst();

        return planet.orElseThrow();
    }

}
