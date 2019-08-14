package com.example.SpringBootVideo.mapper;

import java.util.List;

import com.example.SpringBootVideo.model.Subject;



public interface SubjectDao {

	void add(Subject subject);

	void delete(int id);

	void update(Subject subject);

	Subject selectOne(int id);

	List<Subject> selectAll();

	List<Subject> likeAll(Subject subject);

	void deleteAll(int[] ids);
}
