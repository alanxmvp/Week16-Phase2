package com.example.hibernate.repositories;

import com.example.hibernate.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {
  // List<User> findAllByEmail(String email);

  // List<User> findAllByFirstName(String firstName);

  // List<User> findAllByLastName(String lastName);

  // List<User> findAllByPhone(String phone);

  // List<User> findAllByFirstNameAndEmail(String firstName, String email);

}