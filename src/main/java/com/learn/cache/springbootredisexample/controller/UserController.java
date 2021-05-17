package com.learn.cache.springbootredisexample.controller;

import com.learn.cache.springbootredisexample.repository.UserRepositoryImpl;
import com.learn.cache.springbootredisexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepositoryImpl userRepository;

    @PostMapping("/save")
    public User add(@RequestBody User user) {
        return userRepository.save(user);
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
        return userRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id) {
        return userRepository.delete(id);
    }























}
