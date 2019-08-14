package com.example.SpringBootVideo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootVideo.mapper.CourseDao;
import com.example.SpringBootVideo.model.Course;
import com.example.SpringBootVideo.service.CourseService;

@Service
public class HCourseServiceImpl implements CourseService{
	
	@Autowired
	CourseDao courseDao;

	public void add(Course course) {
		courseDao.add(course);
		
	}

	public void delete(int id) {
		courseDao.delete(id);
		
	}

	public void update(Course course) {
		courseDao.update(course);
		
	}

	public Course selectOne(int id) {
		// TODO Auto-generated method stub
		return courseDao.selectOne(id);
	}

	public List<Course> selectAll() {
		// TODO Auto-generated method stub
		return courseDao.selectAll();
	}

	public List<Course> likeAll(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteAll(Integer[] ids) {
		// TODO Auto-generated method stub
		return courseDao.deleteAll(ids);
	}

	public List<Course> selectHtml(Integer id) {
		// TODO Auto-generated method stub
		return courseDao.selectHtml(id);
	}

	public void deleteIn(ArrayList<Integer> ids) {
		// TODO Auto-generated method stub
		courseDao.deleteIn(ids);
	}

}
