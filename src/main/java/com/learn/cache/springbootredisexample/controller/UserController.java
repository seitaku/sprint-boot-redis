package com.learn.cache.springbootredisexample.controller;

import com.learn.cache.springbootredisexample.model.UUserEntity;
import com.learn.cache.springbootredisexample.model.UserRedisEntity;
import com.learn.cache.springbootredisexample.model.singleton.SingletonObject;
import com.learn.cache.springbootredisexample.repository.jpa.UUserRepository;
import com.learn.cache.springbootredisexample.repository.redis.UserRedisRepositoryImpl;
import com.learn.cache.springbootredisexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRedisRepositoryImpl userRedisRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public UserRedisEntity add(@RequestBody UserRedisEntity userRedisEntity) {
        return userRedisRepository.saveByHash(userRedisEntity);
    }

    @PostMapping("/save/noHash")
    public UserRedisEntity addNoHash(@RequestBody UserRedisEntity userRedisEntity) {
        return userRedisRepository.saveByNoHash(userRedisEntity);
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
    public List<UserRedisEntity> findAll() {
        return userRedisRepository.findAll();
    }

    @GetMapping("/{id}")
    public UserRedisEntity getRedisDataById(@PathVariable int id) {
        return userRedisRepository.findUserByIdHash(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id) {
        return userRedisRepository.delete(id);
    }


    @GetMapping("/user/{id}")
    public UUserEntity getById(@PathVariable int id) {
        return userService.findUUserById(id);
    }


    public static void main(String[] args) {
        int nums[] = {-1, 3, -10, -20};

        Arrays.stream(nums).toArray();
        long result = 0L;
        for (int i = 0; i < nums.length - 2; i++) {
            result = Math.max(result, nums[i] * nums[i + 1]);
        }

        System.out.println("End");
    }

}
