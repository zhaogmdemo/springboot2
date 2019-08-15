package com.example.SpringBootVideo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootVideo.mapper.UserDao;
import com.example.SpringBootVideo.model.User;
import com.example.SpringBootVideo.service.CQUserService;
import com.example.SpringBootVideo.service.UserService;
@Service
public class CQUserserviceimpl implements CQUserService{
@Autowired
UserDao dao;
	@Override
	
		public User selectAccounts(String accounts) {
			User list=dao.selectAccounts(accounts);
			if(list!=null){
				return list;
			}
			return null;
		}
	@Override
	public void add(User user) {
		dao.add(user);
		
	}
	

}
