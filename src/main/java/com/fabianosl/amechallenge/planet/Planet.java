package com.fabianosl.amechallenge.planet;

import com.fabianosl.amechallenge.planet.dto.CreatePlanetDTO;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String name;

    private String weather;

    private String terrain;

    private int films;

    @CreationTimestamp
    private LocalDateTime createAt;

    public Planet() {
    }

    public Planet(CreatePlanetDTO planetDTO) {
        this.name = planetDTO.getName();
        this.weather = planetDTO.getWeather();
        this.terrain = planetDTO.getTerrain();
    }
}