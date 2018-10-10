package com.onlywell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

@SpringBootApplication(exclude= {RedisAutoConfiguration.class})
public class WebStarter {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(WebStarter.class, args);
	}

}
