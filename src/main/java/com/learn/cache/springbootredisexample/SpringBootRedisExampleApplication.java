package com.learn.cache.springbootredisexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class SpringBootRedisExampleApplication {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisExampleApplication.class, args);
    }

    @Autowired
    private void tDBConnect() throws SQLException {
        System.out.println("測試連線db:" + !dataSource.getConnection().getCatalog().isEmpty());
    }

    @Autowired
    public void say() {
        System.out.println("say Auto print");
    }

}
