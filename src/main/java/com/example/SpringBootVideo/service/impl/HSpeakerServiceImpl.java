package com.example.SpringBootVideo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootVideo.mapper.SpeakerDao;
import com.example.SpringBootVideo.model.Speaker;
import com.example.SpringBootVideo.service.SpeakerService;

@Service
public class HSpeakerServiceImpl implements SpeakerService{
	
	@Autowired
	SpeakerDao speakerDao;
	
	public void add(Speaker speaker) {
		speakerDao.add(speaker);
		
	}

	public void delete(int id) {
		speakerDao.delete(id);
		
	}

	public void update(Speaker speaker) {
		speakerDao.update(speaker);
		
	}

	public Speaker selectOne(int id) {
		// TODO Auto-generated method stub
		return speakerDao.selectOne(id);
	}

	public List<Speaker> selectAll() {
		// TODO Auto-generated method stub
		return speakerDao.selectAll();
	}

	public List<Speaker> likeAll(Speaker speaker) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteAll(int[] ids) {
		// TODO Auto-generated method stub
		
	}

}
