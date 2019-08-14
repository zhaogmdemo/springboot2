package com.example.SpringBootVideo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.SpringBootVideo.model.Video;



public interface VideoService {
	void add(Video video);

	void delete(int id);

	void update(Video video);

	Video selectOne(int id);

	List<Video> selectAll();
	
	List<Video> selectSpeakerId();
	
	List<Video> selectCourse(Integer subjectId);
	
	List<Video> selectVideoFirst(Integer id);
	
	List<Video> selectVideo(Integer id);


	List<Video> likeAll(String factor,Integer speakerId,Integer courseId);

	void deleteAll(int[] ids);
}
