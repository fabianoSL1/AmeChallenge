package com.fabianosl.amechallenge.planet;

import com.fabianosl.amechallenge.planet.dto.CreatePlanetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlanetService {

    private final PlanetRepository planetRepository;

    public List<Planet> getAllPlanets() {
        return planetRepository.findAll();
    }

    public Planet getPlanetById(String id) {
        var planet = planetRepository.findById(id);
        return throwIfNotFund(planet);
    }

    public Planet getPlanetByName(String name) {
        var planet = planetRepository.findByName(name);
        return throwIfNotFund(planet);
    }

    private Planet throwIfNotFund(Optional<Planet> planet) {
        if (planet.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Planet not found");
        }

        return planet.get();
    }

    public Planet createPlanet(CreatePlanetDTO createPlanetDTO) {
        var planet = new Planet(createPlanetDTO);

        return planetRepository.save(planet);
    }

    public Planet deletePlanetById(String id) {
        var planet = getPlanetById(id);

        planetRepository.deleteById(id);

        return planet;
    }
}
