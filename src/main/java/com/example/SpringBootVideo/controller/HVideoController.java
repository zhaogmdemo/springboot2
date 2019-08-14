package com.example.SpringBootVideo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringBootVideo.model.Course;
import com.example.SpringBootVideo.model.Speaker;
import com.example.SpringBootVideo.model.Video;
import com.example.SpringBootVideo.service.CourseService;
import com.example.SpringBootVideo.service.SpeakerService;
import com.example.SpringBootVideo.service.SubjectService;
import com.example.SpringBootVideo.service.VideoService;
import com.example.SpringBootVideo.util.VideoResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class HVideoController {
	
			@Autowired
			VideoService videoService;
			
			@Autowired
			SpeakerService speakerService;
			
			@Autowired
			CourseService courseService;
			
			@Autowired
			SubjectService subjectService;
			
			/*@Autowired
			UserService userService;*/
	
			//��Ƶչʾ����
			@RequestMapping("/VideoShow.do")
			public String getVideoShow(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
				// �ӵ�һ����ʼ ÿҳ��ѯ��������

				PageHelper.startPage(pn, 8);

				List<Video> video = videoService.selectAll();
				List<Speaker> speaker = speakerService.selectAll();
				List<Course> course = courseService.selectAll();
				VideoResult videoResult=new VideoResult();
				videoResult.setData(video);
				videoResult.setMsg("ok");
				videoResult.setStatus(200);
				
				
				VideoResult videoResult2=new VideoResult();
				videoResult2.setData(speaker);
				videoResult2.setMsg("ok");
				videoResult2.setStatus(200);
				
				VideoResult videoResult3=new VideoResult();
				videoResult3.setData(course);
				videoResult3.setMsg("ok");
				videoResult3.setStatus(200);
				
				
				// ���û���Ϣ����PageInfo������
				PageInfo page = new PageInfo(video, 8);
				model.addAttribute("pageInfo", page);
				model.addAttribute("Video", videoResult);
				model.addAttribute("Speaker", videoResult2);
				model.addAttribute("Course",  videoResult3);
				//model.addAttribute("pageInfo1", speaker);
				return "Video";
			}
			
			
		/*	//ģ����ѯ��Ƶչʾ����
			@ResponseBody
			@RequestMapping("/VideoLikeShow1.do")
			public  ModelAndView ModelAndView1(HttpServletRequest req, HttpServletResponse resp,@RequestParam(value = "pn", defaultValue = "1") Integer pn, 
					ModelAndView model,@Param("speaker_id")Integer speaker_id,@Param("course_id")Integer course_id) {
				// �ӵ�һ����ʼ ÿҳ��ѯ��������
				System.out.println(speaker_id);
				//PageHelper.startPage(pn, 3);

				List<Video> video = videoService.likeAll(speaker_id, course_id);
				System.out.println(video);
				PageHelper.startPage(pn, 3);
				// ���û���Ϣ����PageInfo������
				PageInfo page = new PageInfo(video, 3);
				//model.addAttribute("pageInfo", page);
				model.addObject("pageInfo", page);
				model.setViewName("Video");
				//model.addAttribute("Speaker", speakerService.selectAll());
				//model.addAttribute("Course",  courseService.selectAll());
				//model.addAttribute("pageInfo1", speaker);
				return model;
				
				ModelAndView mav = new ModelAndView("redirect:/VideoShow.do");
				return mav;
			}
			*/
			@RequestMapping("/VideoLikeShow.do")
			public String getVideoShow1(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model,
					@Param("title")String title,@Param("factor")String factor,@Param("speaker_id")Integer speaker_id,@Param("course_id")Integer course_id) {
				// �ӵ�һ����ʼ ÿҳ��ѯ��������
				System.out.println("1");
				PageHelper.startPage(pn, 9);

				List<Video> video = videoService.likeAll(factor,speaker_id, course_id);
				System.out.println(video);
				
				// ���û���Ϣ����PageInfo������
				PageInfo page = new PageInfo(video, 9);
				model.addAttribute("pageInfo", page);
				model.addAttribute("Speaker", speakerService.selectAll());
				model.addAttribute("Course",  courseService.selectAll());
				//model.addAttribute("pageInfo1", speaker);
				return "Video";
			}
			
			//������ӽ���
			@RequestMapping("/addVideo.do")
			public String getCourseAdd(Model model) {
				model.addAttribute("Subject", subjectService.selectAll());
				model.addAttribute("Course",  courseService.selectAll());
				model.addAttribute("Speaker",  speakerService.selectAll());
				return "VideoAdd";
			}
			
			
			//��Ӻ󷵻ؿγ̽���
			@RequestMapping("/AddVideo.do")
			public String addUser(Model model, Video video) {
				if (video != null) {
					videoService.add(video);
				}
				return "redirect:/VideoShow.do";
			}
			
			
			//���뵽�༭����
			@RequestMapping("/getVideo.do")
			public String getVideo(int id, Model model) {

				//Course course=courseService.selectOne(id);		
				//Subject subject=subjectService.selectOne(Integer.valueOf(course.getSubject_id()));
				model.addAttribute("Video", videoService.selectOne(id));
				model.addAttribute("Course",  courseService.selectAll());
				model.addAttribute("Speaker",  speakerService.selectAll());
				//model.addAttribute("Subject", subject);
				return "VideoEdit";
			}
			
			//�༭�󷵻ؿγ̽���
			@RequestMapping("/updateVideo.do")
			public ModelAndView UpdateUser(Model model, Video video) {

				videoService.update(video);

				ModelAndView mav = new ModelAndView("redirect:/VideoShow.do");
				return mav;

			}
			
			
			//ɾ������
			@RequestMapping("/delVideo.do")
			public ModelAndView deleteUser(int id, Model model) {
				videoService.delete(id);
				ModelAndView mav = new ModelAndView("redirect:/VideoShow.do");

				return mav;
			}
			
			
			
			@RequestMapping("/VideoPlay.do")
			public String getVideoPlay(HttpServletRequest req, HttpServletResponse resp,Integer id ,Integer UserId,Model model) {
			
				//User userId=userService.selectOne(UserId);
				//req.getSession().setAttribute("user",userId);
				List<Video> video1 = videoService.selectVideoFirst(id);
				System.out.println("------");
				List<Video> video2 = videoService.selectVideo(id);
				System.out.println(".........");
				System.out.println(video1);
				System.out.println(video2);
				
				model.addAttribute("video1", video1);
				model.addAttribute("video2", video2);
				//User user = videoService.selectOne(id);
				// ���û���Ϣ����PageInfo������
				//req.getSession().setAttribute("user",user);
				//model.addAttribute("user", user);
				/*List<Course> course=courseService.selectHtml();
				List<Video> video = videoService.selectCourse();
				model.addAttribute("video", video);
				model.addAttribute("course", course);*/
				return "VideoPlay";
			}

}
