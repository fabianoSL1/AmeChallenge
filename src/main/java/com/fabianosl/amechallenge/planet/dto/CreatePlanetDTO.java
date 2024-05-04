package com.fabianosl.amechallenge.planet.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePlanetDTO {
    private String name;

    private String weather;

    private String terrain;
}
