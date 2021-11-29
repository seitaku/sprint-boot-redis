package com.learn.cache.springbootredisexample.service.implement;

import com.learn.cache.springbootredisexample.model.UUserEntity;
import com.learn.cache.springbootredisexample.repository.jpa.UUserRepository;
import com.learn.cache.springbootredisexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepositoryImpl implements UserService {
    @Autowired
    private UUserRepository userRepository;

    @Override
    public UUserEntity save(UUserEntity uUserEntity) {
        return null;
    }

    @Override
    public List<UUserEntity> findAll() {
        return null;
    }

    @Override
    public UUserEntity findUUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public String delete(int id) {
        return null;
    }
}
