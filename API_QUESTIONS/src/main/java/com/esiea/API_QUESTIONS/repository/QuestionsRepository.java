package com.esiea.API_QUESTIONS.repository;

import com.esiea.API_QUESTIONS.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionsRepository extends JpaRepository<Questions, Long> {
    Optional<Questions> findByQuestion(String question);
}
