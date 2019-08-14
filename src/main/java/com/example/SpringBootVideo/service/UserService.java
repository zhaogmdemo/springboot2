package com.example.SpringBootVideo.service;

import java.util.List;

import com.example.SpringBootVideo.model.User;



public interface UserService {
	void add(User user);

	void delete(int id);

	void update(User user);

	void updatePassword(String password,Integer id);

	
	User selectOne(int id);
	
	User selectName(String name);


	List<User> selectAll();

	List<User> likeAll(User user);

	Integer  deleteAll(int[] ids);
}
