package com.fabianosl.amechallenge.swapi.dto;

import lombok.Data;
import java.util.List;

@Data
public class Planet {
    String name;
    List<String> films;
}
