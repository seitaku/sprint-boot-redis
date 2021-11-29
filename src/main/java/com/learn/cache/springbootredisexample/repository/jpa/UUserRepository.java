package com.learn.cache.springbootredisexample.repository.jpa;

import com.learn.cache.springbootredisexample.model.UUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UUserRepository extends JpaRepository<UUserEntity, Integer> {

    UUserEntity findById(int id);
}
