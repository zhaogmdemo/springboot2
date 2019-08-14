package com.example.SpringBootVideo.mybatisConf;

import java.util.Properties;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import com.github.pagehelper.PageHelper;

@SpringBootConfiguration
public class MybatisConf {
	
	@Bean
	public PageHelper pageHelper(){
		PageHelper pageHelper = new PageHelper();
		
		Properties properties = new Properties();
		
		properties.setProperty("offsetAspageNum", "true");
		
		properties.setProperty("rowBoundsWithCount", "true");
		
		properties.setProperty("reasonable", "true");
		pageHelper.setProperties(properties);
		return pageHelper;
	}

}
