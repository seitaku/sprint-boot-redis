package com.learn.cache.springbootredisexample.Service;

import com.learn.cache.springbootredisexample.Service.implement.ICar;
import org.springframework.stereotype.Service;

@Service
public class BCarService implements ICar {
    @Override
    public void say() {
        Class<?> enclosingClass = getClass().getEnclosingClass();
        if (enclosingClass != null) {
            System.out.println(enclosingClass.getName());
        } else {
            System.out.println(getClass().getName());
        }
    }
}
