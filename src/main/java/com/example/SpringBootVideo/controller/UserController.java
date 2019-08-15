package com.example.SpringBootVideo.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.SpringBootVideo.model.Course;
import com.example.SpringBootVideo.model.User;
import com.example.SpringBootVideo.model.Video;
import com.example.SpringBootVideo.service.CQUserService;
import com.example.SpringBootVideo.service.CourseService;
import com.example.SpringBootVideo.service.VideoService;
import com.example.SpringBootVideo.util.MD5Utils;
import com.example.SpringBootVideo.service.UserService;


@Controller
public class UserController {
	@Autowired
	VideoService VideoService;
	@Autowired
	CourseService courseService;
	@Autowired
	CQUserService UserService;
	
	@ResponseBody
	@RequestMapping(value="UserAdd.action")
	public String Useradd(User User,HttpServletRequest req){
		String md5=MD5Utils.md5(User.getPassword());
		User.setPassword(md5);
		UserService.add(User);
		
		return "index";
	}
	
	/*@RequestMapping(value="UserPasswordUpdate.action")
	public String UserPasswordUpdate(String password,String accounts,HttpServletRequest req){

		UserService.updatePassword(password,accounts);
		User user2=UserService.selectAcoounts(accounts);
		req.getSession().setAttribute("user2s",user2);
		
		return "forward:UserShow.action";
	}*/
/*	�û�ע���ж��û����Ƿ���� */
	@ResponseBody
	@RequestMapping(value="UserExist.action")
	public Map<String,String> UserExist(String accounts){
		User user = UserService.selectAccounts(accounts);
		Map<String,String> map=new HashMap<String, String>();
		if(user!=null){
			map.put("cs", "1");
		}else{
			map.put("cs", "2");
		}
		return map;
	}
/*	�û���¼��֤     */
	@ResponseBody
	@RequestMapping(value="UserLogin.action")
	public Map<String,String> UserLogin(String accounts,String password,HttpServletRequest req){
		User user = UserService.selectAccounts(accounts);
		String md5=MD5Utils.md5(password);
		Map<String,String> map=new HashMap<String, String>();
		if(user!=null&&user.getPassword().equals(md5)){
			req.getSession().setAttribute("user2s", user);
	
			System.out.println("##########");
			map.put("cs", "2");
			
		}else{
			System.out.println("$$$$$$$$$$$");
			map.put("cs", "1");
		}
		return map;
	}
	@RequestMapping(value="userVideoShow")
	public String userVideoShow(){
		
		return "uservideoshow";
	}
	@RequestMapping(value="index")
	public String index(HttpServletRequest req){
		List<Course> course2s = courseService.selectAll();
				
		req.getSession().setAttribute("course2s", course2s);	
		List<Video> list = VideoService.selectAll();
		req.getSession().setAttribute("video2s", list);	
		return "index";
	}
}

