package com.example.SpringBootVideo.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.SpringBootVideo.mapper.UserDao;
import com.example.SpringBootVideo.model.User;
import com.example.SpringBootVideo.service.UserService;
import com.example.SpringBootVideo.util.FtpUtil;
import com.example.SpringBootVideo.util.PictureResult;





@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	public void add(User user) {
		userDao.add(user);
		
	}

	public void delete(int id) {
		userDao.delete(id);
		
	}

	public void update(User user) {
		userDao.update(user);
		
	}

	public List<User> selectAll() {
		
		return userDao.selectAll();
	}

	

	

	public int selectCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public User selectlike(String name, String name2) {
		// TODO Auto-generated method stub
		return null;
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
	public List<User> likeAll(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteAll(int[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectByAccounts(String accounts) {
		
		return userDao.selectByAccounts(accounts);
	}

	@Override
	public PictureResult upload(MultipartFile uploadFile) {
		String name1 = uploadFile.getOriginalFilename();
		FtpUtil f = new FtpUtil();
		PictureResult result = new PictureResult();
		InputStream inputStream = null;
		String name = getImageName()+name1;
		
		
		try {
			inputStream = uploadFile.getInputStream();
			f.upload(inputStream, name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
				result.setError(0);
			    String url = "ftp://192.168.171.187/"+name;
			    result.setUrl(url);	
			    System.out.println(url);
		return result;
	}
	
public static String getImageName(){
		
		long millis = System.currentTimeMillis();
		
		Random random = new Random();
		
		int end3 = random.nextInt(999);
		
		String str = millis+String.format("%03d", end3);
		
		return str;
		
	}

	
	

	



	

	
	
}
