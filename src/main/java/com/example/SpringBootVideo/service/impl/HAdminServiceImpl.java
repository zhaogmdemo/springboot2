package com.example.SpringBootVideo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBootVideo.mapper.AdminDao;
import com.example.SpringBootVideo.model.Admin;
import com.example.SpringBootVideo.service.AdminService;


@Service
public class HAdminServiceImpl implements AdminService{

	@Autowired
	AdminDao adminDao;
	
	public void add(Admin admin) {
		adminDao.add(admin);
		
	}

	public void delete(int id) {
		adminDao.delete(id);
		
	}

	public void update(Admin admin) {
		adminDao.update(admin);
		
	}

	public Admin selectOne(int id) {
		// TODO Auto-generated method stub
		return adminDao.selectOne(id);
	}

	public List<Admin> selectAll() {
		// TODO Auto-generated method stub
		return adminDao.selectAll();
	}

	public List<Admin> likeAll(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteAll(int[] ids) {
		// TODO Auto-generated method stub
		
	}

	public Admin selectName(String name) {
		// TODO Auto-generated method stub
		return adminDao.selectName(name);
	}

}
