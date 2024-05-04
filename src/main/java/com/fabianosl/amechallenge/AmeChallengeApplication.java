package com.fabianosl.amechallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AmeChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmeChallengeApplication.class, args);
    }

}
