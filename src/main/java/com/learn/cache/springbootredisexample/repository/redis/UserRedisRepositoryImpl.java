package com.learn.cache.springbootredisexample.repository.redis;

import com.learn.cache.springbootredisexample.model.UserRedisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class UserRedisRepositoryImpl {

    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY_USER = "user";

    /**
     * 保存物件hash
     */
    public UserRedisEntity saveByHash(UserRedisEntity userRedisEntity) {
        redisTemplate.opsForHash().put(KEY_USER, userRedisEntity.getId(), userRedisEntity);
        return userRedisEntity;
    }

    /**
     * 保存物件hash
     */
    public UserRedisEntity saveByNoHash(UserRedisEntity userRedisEntity) {
        redisTemplate.opsForValue().set(KEY_USER, userRedisEntity);
        return userRedisEntity;
    }

    /**
     * 保存字串
     */
    public UserRedisEntity saveByString(UserRedisEntity userRedisEntity) {
        String redisKey = KEY_USER + "::" + userRedisEntity.getId();
        redisTemplate.opsForValue().set(redisKey, userRedisEntity, 30, TimeUnit.SECONDS);
        return userRedisEntity;
    }

    public List<UserRedisEntity> findAll() {
        return redisTemplate.opsForHash().values(KEY_USER);
    }


    public UserRedisEntity findUserByIdHash(int id) {
        return (UserRedisEntity) redisTemplate.opsForHash().get(KEY_USER, id);
    }


    public String delete(int id) {
        redisTemplate.opsForHash().delete(KEY_USER, id);
        return "user id: " + id + " removed !!";
    }






}
