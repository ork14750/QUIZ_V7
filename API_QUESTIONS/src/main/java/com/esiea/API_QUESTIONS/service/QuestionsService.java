package com.esiea.API_QUESTIONS.service;

import com.esiea.API_QUESTIONS.model.Questions;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface QuestionsService {
    void save(Questions questions);

    Optional<Questions> findByQuestion(String question);

    void loadDataQuestions();

    Collection<Questions> getAllQuestions();

    List<Questions> getRandomQuestions();

}
