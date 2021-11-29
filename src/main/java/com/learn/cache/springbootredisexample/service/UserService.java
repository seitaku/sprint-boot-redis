package com.learn.cache.springbootredisexample.service;

import com.learn.cache.springbootredisexample.model.UUserEntity;

import java.util.List;

public interface UserService {

     UUserEntity save(UUserEntity uUserEntity);

     List<UUserEntity> findAll();

     UUserEntity findUUserById(int id);

     String delete(int id);
}
