package com.learn.cache.springbootredisexample.model.singleton;

import org.springframework.stereotype.Component;

/**
 * 試做單例模式
 */
@Component
public class SingletonObject {

    private SingletonObject() {
        // something
    }

    public static SingletonObject getInstance() {
        return SingletonClassHolder.instance;
    }

    private static class SingletonClassHolder {
        private static SingletonObject instance;
        static {
            instance = new SingletonObject();
            System.out.println("SingletonObject init");
        }
    }
}
