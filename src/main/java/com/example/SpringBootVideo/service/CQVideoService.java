package com.example.SpringBootVideo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.SpringBootVideo.model.Video;



public interface CQVideoService {
	

	Video selectOne(int id);

	List<Video> selectAll();
	List<Video> selectVideoCourse(int course_id);
	
	List<Video> selectVideo(Integer id);


}
