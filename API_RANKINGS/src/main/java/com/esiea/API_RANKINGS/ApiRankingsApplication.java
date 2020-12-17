package com.esiea.API_RANKINGS;

import com.esiea.API_RANKINGS.service.PlayerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiRankingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRankingsApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(PlayerService playerService) {
		return (args) -> {
			// save a few customers
			playerService.loadDataUsers();


		};
	}

}
