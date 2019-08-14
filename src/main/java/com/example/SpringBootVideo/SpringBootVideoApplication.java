package com.example.SpringBootVideo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.SpringBootVideo.mapper")
public class SpringBootVideoApplication {

	public static void main(String[] args) {
		System.out.println("here111");
		SpringApplication.run(SpringBootVideoApplication.class, args);
	}

}
