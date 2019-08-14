package com.example.SpringBootVideo.mapper;

import java.util.List;

import com.example.SpringBootVideo.model.Admin;



public interface AdminDao {

	void add(Admin admin);

	void delete(int id);

	void update(Admin admin);

	Admin selectOne(int id);
	
	Admin selectName(String name);

	List<Admin> selectAll();

	List<Admin> likeAll(Admin admin);

	void deleteAll(int[] ids);

}
