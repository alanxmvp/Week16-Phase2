
package com.example.hibernate.controllers;

import java.util.List;

import com.example.hibernate.entities.Answer;
import com.example.hibernate.repositories.AnswerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(path = "/api")
public class AnswerController {

  @Autowired
  AnswerRepository answerRepository;

  @PostMapping(value = "/questions/{id}/answers")
  public void createAnswer(@RequestBody Answer answer, @PathVariable("id") long id) {
    answer.setQuestionId(id);
    answerRepository.save(answer);
  }

  @PostMapping(value = "/answer/{id}")
  public void updateAnswer(@RequestBody Answer answer, @PathVariable("id") long id) {
    Answer existingAnswer = answerRepository.findById(id).orElse(new Answer());
    if (existingAnswer.getId() != null) {
      answer.setId(id);
      answerRepository.save(answer);
    }
    ;
  }

  @GetMapping(value = "/questions/{id}/answers", produces = "application/json")
  public List<Answer> getAnswerByQuestId(@PathVariable long id) {
    return answerRepository.findAllByQuestionId(id);
  }
}