package com.example.SpringBootVideo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.SpringBootVideo.model.Video;
import com.example.SpringBootVideo.service.SpeakerService;
import com.example.SpringBootVideo.service.VideoService;



@Controller
public class VideoController {
	@Autowired
	SpeakerService dao;
	@Autowired
	VideoService VideoService;
	
	
	
	
	
	@ResponseBody
	@RequestMapping(value="VideoDisplay.action")
	public String VideoDisplay(HttpServletRequest req, HttpServletResponse resp){
		int video_id=Integer.valueOf(req.getParameter("video_id"));
		int course_id=Integer.valueOf(req.getParameter("course_id"));
		Video list = VideoService.selectOne(video_id);

		List<Video> selectCourse = VideoService.selectCourse(course_id);
		req.getSession().setAttribute("video3s", list);
		req.getSession().setAttribute("videc3s", selectCourse);
	
		return "2";
	}
	
	
	
	
	
}
