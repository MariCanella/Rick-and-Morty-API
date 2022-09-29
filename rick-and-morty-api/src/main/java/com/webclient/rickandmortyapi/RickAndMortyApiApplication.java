package com.webclient.rickandmortyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class RickAndMortyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RickAndMortyApiApplication.class, args);
	}

}
