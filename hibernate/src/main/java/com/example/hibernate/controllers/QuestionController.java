
package com.example.hibernate.controllers;

import com.example.hibernate.entities.Question;
import com.example.hibernate.repositories.QuestionRepository;
import com.example.hibernate.repositories.AnswerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class QuestionController {

  @Autowired
  QuestionRepository questionRepository;

  @Autowired
  AnswerRepository answerRepository;

  @PostMapping(value = "/questions")
  public void addQuestion(@RequestBody Question question) {
    questionRepository.save(question);
  }
}