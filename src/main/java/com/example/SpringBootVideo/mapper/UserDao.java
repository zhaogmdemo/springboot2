package com.example.SpringBootVideo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.SpringBootVideo.model.User;



public interface UserDao {
	void add(User user);

	void delete(int id);

	void update(User user);

	void updatePassword(@Param("password")String password,@Param("id")Integer id);
	
	User selectOne(int id);
	
	User selectName(String name);

	List<User> selectAll();

	List<User> likeAll(User user);

	void deleteAll(int[] ids);
}
