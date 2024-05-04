package com.fabianosl.amechallenge.planet.dto;

import lombok.Data;

@Data
public class CreatePlanetDTO {
    private String name;

    private String weather;

    private String terrain;
}
