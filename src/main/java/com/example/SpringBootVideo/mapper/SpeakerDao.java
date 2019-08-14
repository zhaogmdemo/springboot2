package com.example.SpringBootVideo.mapper;

import java.util.List;

import com.example.SpringBootVideo.model.Speaker;



public interface SpeakerDao {

	void add(Speaker speaker);

	void delete(int id);

	void update(Speaker speaker);

	Speaker selectOne(int id);

	List<Speaker> selectAll();

	List<Speaker> likeAll(Speaker speaker);

	void deleteAll(int[] ids);
}
