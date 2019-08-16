package com.example.SpringBootVideo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
@EnableCaching
@SpringBootApplication
@MapperScan("com.example.SpringBootVideo.mapper")
public class SpringBootVideoApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootVideoApplication.class, args);
	}

}
