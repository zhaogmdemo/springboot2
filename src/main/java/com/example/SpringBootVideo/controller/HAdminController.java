package com.example.SpringBootVideo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


import com.alibaba.fastjson.JSON;
import com.example.SpringBootVideo.model.Admin;
import com.example.SpringBootVideo.model.Course;
import com.example.SpringBootVideo.model.Subject;
import com.example.SpringBootVideo.model.User;
import com.example.SpringBootVideo.model.Video;
import com.example.SpringBootVideo.service.AdminService;
import com.example.SpringBootVideo.service.CourseService;
import com.example.SpringBootVideo.service.SubjectService;
import com.example.SpringBootVideo.service.UserService;
import com.example.SpringBootVideo.service.VideoService;
import com.example.SpringBootVideo.util.VideoResult;
@Controller
public class HAdminController {

	@Autowired
	CourseService courseService;
	
	@Autowired
	SubjectService subjectService;
	
	
	
	@Autowired
	VideoService videoService;

	@Autowired
	AdminService adminservice;
	
	


	
	//课程展示界面
	/**
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("/AdminLoginManager.do")
	public String getAdmin(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
		// 从第一条开始 每页查询四条数据1111
		
		PageHelper.startPage(pn, 4);
		List<Admin> admin = adminservice.selectAll();
		VideoResult videoResult=new VideoResult();
		videoResult.setData(admin);
		videoResult.setMsg("ok");
		videoResult.setStatus(200);
		// 将用户信息放入PageInfo对象里
		//PageInfo page = new PageInfo(course, 4);
		PageInfo page=new PageInfo(admin, 4);
		model.addAttribute("pageInfo", page);
		model.addAttribute("videoResult", videoResult);
		return "AdminManager";
	}

	
	//进入添加界面
	@RequestMapping("/ManageraddCourse.do")
	public String getCourseAdd(Model model) {
		List<Subject> subject = subjectService.selectAll();
		VideoResult videoResult=new VideoResult();
		videoResult.setData(subject);
		videoResult.setMsg("ok");
		videoResult.setStatus(200);
		model.addAttribute("Subject", videoResult);
		return "CourseAdd";
	}

	//添加后返回课程界面
	@RequestMapping("/ManagerAddCourse.do")
	public String addUser(Model model, Course course) {
		if (course != null) {
			courseService.add(course);
		}
		return "redirect:/AdminLogin.do";
	}

	//删除操作
	@RequestMapping("/ManagerdelCourse.do")
	public ModelAndView deleteUser(int id, Model model) {
		courseService.delete(id);
		ModelAndView mav = new ModelAndView("redirect:/AdminLogin.do");

		return mav;
	}
	
	@RequestMapping("/ManagercourseDeleteAll.do")
	public String deleteAll(String ids) {

		List<Integer> Array = JSON.parseArray(ids, Integer.class);
	 
//		  for (Integer integer : Array) { 
//			  
//			  System.out.println(integer); 
//		  
//		  }
		  
        courseService.deleteIn((ArrayList<Integer>)Array);	
		return "forward:/AdminLogin1.do";

	}
	
	@RequestMapping("/ManagerdeleteMany1.do")
	public String deleteSelect(String[] ids,Model model){
		System.out.println("123"+ids);
		try {
			//批量删除
			//courseService.deleteAll(ids);
		} catch (Exception e) {
			return "error";
		}
		return "ok";
		}
		

	@RequestMapping("/ManagerdeleteMany.do")
	public String deleteManyChildren(Integer[] id){
		System.out.println("120");
		System.out.println(id);
		int i = courseService.deleteAll(id);
		//如果删除成功
		if(i > 0){
			//重定向到幼儿管理主界面
			return "redirect:/AdminLogin.do";
		}
		//删除异常
		return "404";

	}

	//进入到编辑界面
	@RequestMapping("/ManagergetCourse.do")
	public String getUser(int id, Model model) {

		Course course=courseService.selectOne(id);		
		Subject subject=subjectService.selectOne(Integer.valueOf(course.getSubjectId()));
		model.addAttribute("Course", courseService.selectOne(id));
		model.addAttribute("Subject", subject);
		return "CourseEdit";
	}

	//编辑后返回课程界面
	@RequestMapping("/ManagerupdateCourse.do")
	public ModelAndView UpdateUser(Model model, Course course) {

		courseService.update(course);

		ModelAndView mav = new ModelAndView("redirect:/AdminLogin.do");
		return mav;

	}
	
	
	
	
	@RequestMapping("/ManagerCourseInfo.do")
	public String getCourseInfo(HttpServletRequest req, HttpServletResponse resp,Integer id ,Integer subject_id,Model model) {
	
		System.out.println("hereerer");
		//User user = userService.selectOne(id);
		// 将用户信息放入PageInfo对象里
		//req.getSession().setAttribute("user",user);
		//model.addAttribute("user", user);
		List<Course> course=courseService.selectHtml(subject_id);
		List<Video> video = videoService.selectCourse(subject_id);
		model.addAttribute("video", video);
		model.addAttribute("course", course);
		return "CourseShowInfo";
	}
	
	
	
	
	
	
	
	

}
