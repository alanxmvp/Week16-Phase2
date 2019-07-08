package com.example.hibernate.repositories;

import java.util.List;

import com.example.hibernate.entities.Question;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {
  // SELECT * FROM question WHERE description LIKE '%?%';
  List<Question> findAllByDescContaining(String description);
}