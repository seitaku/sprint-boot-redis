package com.learn.cache.springbootredisexample.repository;

import com.learn.cache.springbootredisexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    private static final String KEY_USER = "user";

    public User save(User user) {
        redisTemplate.opsForHash().put(KEY_USER, user.getId(), user);
        return user;
    }


    public List<User> findAll() {
        return redisTemplate.opsForHash().values(KEY_USER);
    }


    public User findById(int id) {
        return (User) redisTemplate.opsForHash().get(KEY_USER, id);
    }

    public String delete(int id) {
        redisTemplate.opsForHash().delete(KEY_USER, id);
        return "user id: " + id + " removed !!";
    }
}
