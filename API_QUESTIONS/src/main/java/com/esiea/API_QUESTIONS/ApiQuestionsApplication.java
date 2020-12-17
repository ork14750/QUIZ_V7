package com.esiea.API_QUESTIONS;

import com.esiea.API_QUESTIONS.service.QuestionsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiQuestionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiQuestionsApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(QuestionsService questionsService) {
		return (args) -> {
			// save a few customers
			questionsService.loadDataQuestions();


		};
	}

}
