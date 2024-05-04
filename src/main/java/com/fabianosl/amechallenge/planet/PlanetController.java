package com.fabianosl.amechallenge.planet;

import com.fabianosl.amechallenge.planet.dto.CreatePlanetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/planets")
public class PlanetController {

    private final PlanetService planetService;

    @GetMapping
    public List<Planet> getAllPlanets(@Param("name") String name) {

        if (name != null) {
            var planet = planetService.getPlanetByName(name);
            return List.of(planet);
        }

        return planetService.getAllPlanets();
    }

    @GetMapping("/{id}")
    public Planet getPlanetById(@PathVariable String id) {
        return planetService.getPlanetById(id);
    }

    @PostMapping
    public Planet createPlanet(@RequestBody CreatePlanetDTO CreatePlanetDTO) {
        return planetService.createPlanet(CreatePlanetDTO);
    }

    @DeleteMapping("/{id}")
    public Planet deletePlanet(@PathVariable String id) {
        return planetService.deletePlanetById(id);
    }
}
