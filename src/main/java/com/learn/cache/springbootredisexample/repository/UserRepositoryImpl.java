package com.learn.cache.springbootredisexample.repository;

import com.learn.cache.springbootredisexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class UserRepositoryImpl {

//    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY_USER = "user";

    /**
     * 保存物件hash
     */
    public User saveByHash(User user) {
        redisTemplate.opsForHash().put(KEY_USER, user.getId(), user);
        return user;
    }

    /**
     * 保存字串
     */
    public User saveByString(User user) {
        String redisKey = KEY_USER + "::" + user.getId();
        redisTemplate.opsForValue().set(redisKey, user, 30, TimeUnit.SECONDS);
        return user;
    }

    public List<User> findAll() {
        return redisTemplate.opsForHash().values(KEY_USER);
    }


    public User findUserByIdHash(int id) {
        return (User) redisTemplate.opsForHash().get(KEY_USER, id);
    }


    public String delete(int id) {
        redisTemplate.opsForHash().delete(KEY_USER, id);
        return "user id: " + id + " removed !!";
    }






}
