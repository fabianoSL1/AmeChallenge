package com.fabianosl.amechallenge.planet;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface PlanetRepository extends JpaRepository<Planet, String> {
    Optional<Planet> findByName(String name);
}
