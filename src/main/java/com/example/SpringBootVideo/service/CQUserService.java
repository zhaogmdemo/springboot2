package com.example.SpringBootVideo.service;

import com.example.SpringBootVideo.model.User;

public interface 	CQUserService{

	User selectAccounts(String accounts);
	void add(User user);
}
