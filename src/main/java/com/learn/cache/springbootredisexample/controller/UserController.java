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
    private UserService userService;

    @GetMapping("/{id}")
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
