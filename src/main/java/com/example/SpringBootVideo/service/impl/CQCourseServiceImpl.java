package com.example.SpringBootVideo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.example.SpringBootVideo.mapper.CourseDao;
import com.example.SpringBootVideo.model.Course;
import com.example.SpringBootVideo.service.CQCourseService;
@Service
public class CQCourseServiceImpl implements CQCourseService{
	@Autowired
    private CourseDao dao;
	
	@Autowired
	RedisTemplate  redisTemplate;
	public List<Course> selectAll() {
		List<Course> object = (List<Course>) redisTemplate.opsForValue().get("getcourse");
		if(object!=null){
			return object;
		}
		List<Course> course2s = dao.selectAll();
		redisTemplate.opsForValue().set("getcourse",course2s);		
		return course2s;
	}
	 

	    }


