package com.example.SpringBootVideo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.SpringBootVideo.mapper.VideoDao;
import com.example.SpringBootVideo.model.Video;
import com.example.SpringBootVideo.service.CQVideoService;
import com.example.SpringBootVideo.service.VideoService;

@Service
public class CQVideoServiceImpl implements CQVideoService {
	@Autowired
	VideoDao dao;

	@Cacheable(value="getvideo")
		public List<Video> selectAll() {
			List<Video> list = dao.selectAll();
			if(list!=null){
				return list;
			}
			return null;
		}

	@Override
	public Video selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> selectVideo(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> selectVideoCourse(int course_id) {
		List<Video> list = 	dao.selectVideoCourse(course_id);
		if(list!=null){
			return list;
		}
		return null;
	}
		
	
		
		

	
}
		

