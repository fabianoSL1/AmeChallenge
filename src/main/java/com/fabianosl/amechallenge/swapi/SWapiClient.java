package com.fabianosl.amechallenge.swapi;

import com.fabianosl.amechallenge.swapi.dto.PlanetListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SWapiClient {

    private final RestTemplate restTemplate;

    private final String endpoint;

    public SWapiClient(@Value("${swapi.endpoint}") String endpoint, RestTemplate restTemplate) {
        this.endpoint = endpoint;
        this.restTemplate = restTemplate;
    }

    public PlanetListResponse getPlanetByName(String name) {
        String url = endpoint + "/planets?search={name}";
        return restTemplate.getForObject(url, PlanetListResponse.class, name);
    }

}
