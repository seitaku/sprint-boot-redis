package com.learn.cache.springbootredisexample;

import com.learn.cache.springbootredisexample.Service.implement.ICar;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootRedisExampleApplicationTests {

	@Autowired
	@Qualifier("ACarService")
	private ICar aCar;

	@Autowired
	@Qualifier("BCarService")
	private ICar bCar;

	@Test
	void contextLoads() {
		aCar.say();
		bCar.say();
	}

}
