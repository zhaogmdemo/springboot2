package com.example.SpringBootVideo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.SpringBootVideo.model.Video;



public interface VideoDao {
	void add(Video video);

	void delete(int id);

	void update(Video video);

	Video selectOne(int id);

	List<Video> selectSpeakerId();
	
	List<Video> selectCourse(Integer subjectId);
	
	List<Video> selectVideoFirst(Integer VideoId);
	
	List<Video> selectVideo(Integer VideoId);

	
	List<Video> selectAll();


	List<Video> likeAll(@Param("factor")String factor,@Param("speakerId")Integer speakerId,@Param("courseId")Integer courseId);

	void deleteAll(int[] ids);
}
