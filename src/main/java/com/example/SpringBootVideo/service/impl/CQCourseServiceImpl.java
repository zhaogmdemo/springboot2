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

	@Cacheable("getcourse")
	public List<Course> selectAll() {
		


		return dao.selectAll();
	}
	 

	    }


