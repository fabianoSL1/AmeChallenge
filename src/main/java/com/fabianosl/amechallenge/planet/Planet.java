package com.fabianosl.amechallenge.planet;

import com.fabianosl.amechallenge.planet.dto.CreatePlanetDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Planet {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String weather;

    private String terrain;

    public Planet() {}

    public Planet(CreatePlanetDTO planetDTO) {
        this.name = planetDTO.getName();
        this.weather = planetDTO.getWeather();
        this.terrain = planetDTO.getTerrain();
    }
}