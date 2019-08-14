package com.example.SpringBootVideo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.SpringBootVideo.model.Course;



public interface CourseService {

	void add(Course course);

	void delete(int id);

	void update(Course course);
	
	void deleteIn(ArrayList<Integer> ids);

	Course selectOne(int id);

	List<Course> selectAll();
	
	List<Course> selectHtml(Integer id);

	List<Course> likeAll(Course course);

	int deleteAll(Integer[] ids);
}
