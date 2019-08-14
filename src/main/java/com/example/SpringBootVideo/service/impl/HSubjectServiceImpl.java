package com.example.SpringBootVideo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootVideo.mapper.SubjectDao;
import com.example.SpringBootVideo.model.Subject;
import com.example.SpringBootVideo.service.SubjectService;


@Service
public class HSubjectServiceImpl implements SubjectService{

	@Autowired
	SubjectDao subjectDao;
	
	public void add(Subject subject) {
		subjectDao.add(subject);
		
	}

	public void delete(int id) {
		subjectDao.delete(id);
		
	}

	public void update(Subject subject) {
		subjectDao.update(subject);
		
	}

	public Subject selectOne(int id) {
		// TODO Auto-generated method stub
		return subjectDao.selectOne(id);
	}

	public List<Subject> selectAll() {
		// TODO Auto-generated method stub
		return subjectDao.selectAll();
	}

	public List<Subject> likeAll(Subject subject) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteAll(int[] ids) {
		// TODO Auto-generated method stub
		
	}


}
