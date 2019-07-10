
package com.example.hibernate.controllers;

import java.util.List;

import com.example.hibernate.entities.User;
import com.example.hibernate.repositories.UserRepository;
import com.example.hibernate.entities.Answer;
import com.example.hibernate.repositories.AnswerRepository;
import com.example.hibernate.entities.Question;
import com.example.hibernate.repositories.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class UserController {

  @Autowired
  UserRepository userRepository;

  @Autowired
  AnswerRepository answerRepository;

  @Autowired
  QuestionRepository questionRepository;

  @PostMapping(value = "/users")
  public void addUser(@RequestBody User user) {
    userRepository.save(user);
  }

  @DeleteMapping(value = "/users/{id}")
  public void deleteUser(@PathVariable("id") long id) {
    User user = userRepository.findById(id).orElse(new User());
    if (user.getId() != null) {
      List<Answer> answer = answerRepository.findByUserId(user.getId());
      answerRepository.deleteAll(answer);
      List<Question> question = questionRepository.findByUserId(user.getId());
      questionRepository.deleteAll(question);

      userRepository.delete(user);
    }
  }

}