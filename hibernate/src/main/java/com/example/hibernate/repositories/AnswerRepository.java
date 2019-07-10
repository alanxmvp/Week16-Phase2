package com.example.hibernate.repositories;

import java.util.List;

import com.example.hibernate.entities.Answer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */
public interface AnswerRepository extends JpaRepository<Answer, Long> {
  List<Answer> findByUserId(long userId);

  List<Answer> findAllByQuestionId(long questionId);
}