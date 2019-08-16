package com.example.SpringBootVideo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.SpringBootVideo.model.Course;
import com.example.SpringBootVideo.model.Video;
import com.example.SpringBootVideo.service.CQVideoService;
import com.example.SpringBootVideo.service.SpeakerService;
import com.example.SpringBootVideo.service.VideoService;



@Controller
public class VideoController {
	@Autowired
	SpeakerService dao;
	@Autowired
	CQVideoService VideoService;
	
	
	
	
	
	@ResponseBody
	@RequestMapping(value="VideoDisplay.action")
	public String VideoDisplay(HttpServletRequest req, HttpServletResponse resp){
		if(req.getSession().getAttribute("user2s")!=null){
		int videoId=Integer.valueOf(req.getParameter("videoId"));
		int courseId=Integer.valueOf(req.getParameter("courseId"));
		Video list = VideoService.selectOne(videoId);

		List<Video> selectCourse = VideoService.selectVideoCourse(courseId);
		req.getSession().setAttribute("video3s", list);
		req.getSession().setAttribute("videc3s", selectCourse);
		return "1";
		}
		return "2";
	}
	@RequestMapping(value="VideoDisplay2.action")
	public String VideoDisplay2(HttpServletRequest req, HttpServletResponse resp){
		
		int videoId=Integer.valueOf(req.getParameter("videoId"));
		int courseId=Integer.valueOf(req.getParameter("courseId"));
		Video list = VideoService.selectOne(videoId);

		List<Video> selectCourse = VideoService.selectVideoCourse(courseId);
		req.getSession().setAttribute("video3s", list);
		req.getSession().setAttribute("videc3s", selectCourse);
		return "videodisplay";
		
		
	}
	@RequestMapping(value="login")
	public String index(HttpServletRequest req){
	
		return "login";
	}
	@RequestMapping(value="videodisplay")
	public String VideoDisplay(HttpServletRequest req){
	
		return "videodisplay";
	}
	
	
	
}
