package com.example.SpringBootVideo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootVideo.mapper.VideoDao;
import com.example.SpringBootVideo.model.Video;
import com.example.SpringBootVideo.service.VideoService;


@Service
public class HVideoServiceImpl implements VideoService{

	@Autowired
	VideoDao videoDao;
	
	public void add(Video video) {
		videoDao.add(video);
		
	}

	public void delete(int id) {
		videoDao.delete(id);
		
	}

	public void update(Video video) {
		videoDao.update(video);
		
	}

	public Video selectOne(int id) {
		// TODO Auto-generated method stub
		return videoDao.selectOne(id);
	}

	

	
	public void deleteAll(int[] ids) {
		// TODO Auto-generated method stub
		
	}

	public List<Video> selectSpeakerId() {
		// TODO Auto-generated method stub
		return videoDao.selectSpeakerId();
	}

	public List<Video> selectAll() {
		// TODO Auto-generated method stub
		return videoDao.selectAll();
	}

	public List<Video> likeAll(String factor,Integer speakerId,Integer courseId) {
		// TODO Auto-generated method stub
		return videoDao.likeAll(factor,speakerId,courseId);
	}

	public List<Video> selectCourse(Integer id) {
		// TODO Auto-generated method stub
		return videoDao.selectCourse(id);
	}

	public List<Video> selectVideoFirst(Integer id) {
		// TODO Auto-generated method stub
		return videoDao.selectVideoFirst(id);
	}

	public List<Video> selectVideo(Integer id) {
		// TODO Auto-generated method stub
		return videoDao.selectVideo(id);
	}

	
	

	

	

}
