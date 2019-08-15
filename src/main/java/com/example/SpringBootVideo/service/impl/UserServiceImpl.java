package com.example.SpringBootVideo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootVideo.mapper.UserDao;
import com.example.SpringBootVideo.model.User;
import com.example.SpringBootVideo.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao dao;

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePassword(String password, Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User selectOne(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> likeAll(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteAll(int[] ids) {
		// TODO Auto-generated method stub
		return null;
	}
	public User selectAccounts(String accounts) {
		User list=dao.selectAccounts(accounts);
		if(list!=null){
			return list;
		}
		return null;
	}
	}
	
		

