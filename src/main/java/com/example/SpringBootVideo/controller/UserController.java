package com.example.SpringBootVideo.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.SpringBootVideo.model.Course;
import com.example.SpringBootVideo.model.User;
import com.example.SpringBootVideo.model.Video;
import com.example.SpringBootVideo.service.CQCourseService;
import com.example.SpringBootVideo.service.CQUserService;
import com.example.SpringBootVideo.service.CQVideoService;
import com.example.SpringBootVideo.service.CourseService;
import com.example.SpringBootVideo.service.VideoService;
import com.example.SpringBootVideo.util.MD5Utils;
import com.example.SpringBootVideo.service.UserService;


@Controller
public class UserController {
	@Autowired
	CQVideoService VideoService;
	@Autowired
	CQCourseService courseService;
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
	public Map<String,String> UserLogin(String accounts,String password,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		
		Map<String,String> map=new HashMap<String, String>();
		 req.setCharacterEncoding("utf-8");
		 resp.setCharacterEncoding("utf-8");
	     resp.setContentType("text/html;charset=utf-8");

		if((accounts==null||"".equals(accounts))||(password==null||"".equals(password))){	
			            //读取cookie
		        Cookie[] cookies=req.getCookies();
			        //过滤出用户名和密码
		         if(cookies!=null&&cookies.length>0){
			             for(int i=0;i<cookies.length;i++){
			                 //取出用户名
		                 if("cookiename".equals(cookies[i].getName())){
		                     //pwd=cookies[i].getValue();
		                     accounts=URLDecoder.decode(cookies[i].getValue(),"utf-8");
			                }
			                 //取出密码
			                 if("cookiepwd".equals(cookies[i].getName())){
			                	 password=URLDecoder.decode(cookies[i].getValue(),"utf-8");
			                 }
			         }
		      }
		}
	
		User user = UserService.selectAccounts(accounts);
	
		String md5=MD5Utils.md5(password);
	
		if(user!=null&&user.getPassword().equals(md5)){
			req.getSession().setAttribute("user2s", user);
			System.out.println("*********************");
				//创建Cookie对象
				Cookie cookiename=new Cookie("account",URLEncoder.encode(accounts,"utf-8"));
			    Cookie cookiepwd=new Cookie("password",URLEncoder.encode(password,"utf-8"));
				//设置有效时间
			    cookiename.setMaxAge(60*60*24*10);
			    cookiepwd.setMaxAge(60*60*24*10);
			    cookiename.setPath(req.getContextPath()+"/UserLogin.action");
			    cookiepwd.setPath(req.getContextPath()+"/UserLogin.action");
			    System.out.println("#########^^^^^^^^^^^^");
				//发送Cookie给浏览器
				resp.addCookie(cookiename);
				resp.addCookie(cookiepwd);
				map.put("cs", "2");
			
		}else{
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

