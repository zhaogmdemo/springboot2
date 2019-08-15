package com.example.SpringBootVideo.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringBootVideo.model.User;
import com.example.SpringBootVideo.service.UserService;
import com.example.SpringBootVideo.util.PictureResult;



@Controller
public class MJJUserController {
	
	@Autowired
	UserService userService;
	
	/*
	 * 用户登陆
	 */
	@RequestMapping("/Userlogin")
	public ModelAndView Userlogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		//getParameter是根据页面获取数据
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = userService.selectByAccounts(email);
		request.getSession().setAttribute("user", user);	
		return new ModelAndView("redirect:/UserShow");
		
	}
	
	/*
	 * 用户展示
	 */
	@RequestMapping("UserShow")
	public String UserShow(Integer id,HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		/*User user = (User) request.getSession().getAttribute("user");
		User one = userService.selectOne(id);
		System.out.println(user+"------------------");
		request.setAttribute("user", userService.selectByAccounts(user.getAccounts()));*/
		return "Personal Center";
	}
	
	/*
	 * 用户点击修改并回显
	 */
	@RequestMapping("UserUpdate")
	public String UserUpdate(Integer id,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String accounts = request.getParameter("accounts");
		User u = userService.selectOne(17);
		request.setAttribute("user", u);
		return "Modify the data";
	}
	
	/*
	 * 用户修改并提交,然后返回展示界面
	 */
	@RequestMapping("UserAlter")
	public ModelAndView UserAlter(User user,HttpServletRequest request, HttpServletResponse response) throws Exception {
		String accounts = request.getParameter("accounts");
		userService.update(user);
		request.getRequestDispatcher("UserShow").forward(request, response);
		return null;
	}
	
	/*getServletContext().getRealPath("/") 文件路径
	 * System.currentTimeMillis()+file.getOriginalFilename() 文件名
	 * 上传用户头像并修改
	 */
	@RequestMapping("picupload")
	
	public String uploda(MultipartFile file){
		//调用service上传图片
			System.out.println(file+"--------------------------");
		 //userService.upload(file);
		
		//返回上传结果集
		System.out.println("上传了");
		return "Modify the picture";
	}
	
@RequestMapping("upload")
	
	public String upload(MultipartFile file){
		//调用service上传图片
			System.out.println(file+"--------------------------");
		 userService.upload(file);
		
		//返回上传结果集
		System.out.println("上传了");
		return "Modify the picture";
	}

		//修改校验
		@RequestMapping("CheckPassword")
		public void CheckPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		String pass1 = request.getParameter("pass1");
		if (pass1.equals(user.getPassword())) {
			response.getWriter().write("1");
			
		}else {
			response.getWriter().write("0");
		}
	}
		
		@RequestMapping("ChangePassword")
		public void ChangePassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String pass2 = request.getParameter("password");
			User user = (User) request.getSession().getAttribute("user");
			user.setPassword(pass2);
			userService.update(user);
			response.sendRedirect("UserShow");
		}
		
		@RequestMapping("password")
		
		public String password(MultipartFile file){
			
			return "change password";
		}
		
	}
	
	

