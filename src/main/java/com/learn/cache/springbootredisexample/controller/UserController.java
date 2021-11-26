package com.learn.cache.springbootredisexample.controller;

import com.learn.cache.springbootredisexample.model.singleton.SingletonObject;
import com.learn.cache.springbootredisexample.repository.UserRepositoryImpl;
import com.learn.cache.springbootredisexample.model.User;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private SingletonObject singletonObject;


    @PostMapping("/save")
    public User add(@RequestBody User user) {
        return userRepository.saveByHash(user);
    }
//    @GetMapping("/add/{id}/{name}")
//    public User add(@PathVariable("id") String id,
//                    @PathVariable("name") String name) {
//        userRepository.save(new User(id, name, 20000L));
//        return userRepository.findById(id);
//    }

//    @PutMapping("/add/{id}/{name}")
//    public User update(@PathVariable("id") String id,
//                       @PathVariable("name") String name) {
//        userRepository.update(new User(id, name, 10000L));
//        return userRepository.findById(id);
//    }

    @GetMapping("/all")
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id) {
        return userRepository.findUserByIdHash(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id) {
        return userRepository.delete(id);
    }























}
