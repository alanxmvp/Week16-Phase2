
package com.example.hibernate.controllers;

import com.example.hibernate.entities.User;
import com.example.hibernate.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class UserController {

  @Autowired
  UserRepository userRepository;

  @PostMapping(value = "/users")
  public void addUser(@RequestBody User user) {
    userRepository.save(user);
  }

  // @GetMapping(value = "/users", produces = "application/json")
  // public List<User> displayUsers(@RequestParam String firstName, @RequestParam
  // String email) {
  // return userRepository.findAllByFirstNameAndEmail(firstName, email);
  // }

  // @GetMapping(value = "/users/{id}", produces = "application/json")
  // public User displayUser(@PathVariable long id) {
  // return userRepository.findById(id).orElse(new User());
  // }

  // // update
  // @PostMapping(value = "/users/{id}")
  // public void updateUser(@RequestBody User user, @PathVariable("id") long id) {
  // User existingUser = userRepository.findById(id).orElse(new User());
  // if (existingUser.getId() != null) {
  // user.setId(id);
  // userRepository.save(user);
  // }
  // ;
  // }

  // @DeleteMapping(value = "/users/{id}")
  // public void deleteUser(@PathVariable("id") long id) {
  // User user = userRepository.findById(id).orElse(new User());
  // userRepository.delete(user);
  // }

}