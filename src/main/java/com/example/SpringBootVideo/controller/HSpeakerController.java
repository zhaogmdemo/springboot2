package com.example.SpringBootVideo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringBootVideo.model.Speaker;
import com.example.SpringBootVideo.service.SpeakerService;
import com.example.SpringBootVideo.util.VideoResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@Controller
public class HSpeakerController {
	
		@Autowired
		SpeakerService speakerService;
	
	
		//������չʾ����
		@RequestMapping("/SpeakerShow.do")
		public String getAdmin(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
			// �ӵ�һ����ʼ ÿҳ��ѯ��������

			PageHelper.startPage(pn, 4);
			List<Speaker> course = speakerService.selectAll();
			VideoResult videoResult=new VideoResult();
			videoResult.setData(course);
			videoResult.setMsg("ok");
			videoResult.setStatus(200);
			// ���û���Ϣ����PageInfo������
			PageInfo page = new PageInfo(course, 4);
			model.addAttribute("pageInfo", page);
			model.addAttribute("videoResult", videoResult);
			return "Speaker";
		}
		
		//������ӽ���
		@RequestMapping("/addSpeaker.do")
		public String getCourseAdd(Model model) {
			model.addAttribute("Speaker", speakerService.selectAll());
			return "SpeakerAdd";
		}

		//��Ӻ󷵻ؿγ̽���
		@RequestMapping("/AddSpeaker.do")
		public String addUser(Model model, Speaker speaker) {
			if (speaker != null) {
				speakerService.add(speaker);
			}
			return "redirect:/SpeakerShow.do";
		}

		//ɾ������
		@RequestMapping("/delSpeaker.do")
		public ModelAndView deleteUser(int id, Model model) {
			speakerService.delete(id);
			ModelAndView mav = new ModelAndView("redirect:/SpeakerShow.do");

			return mav;
		}

		//���뵽�༭����
		@RequestMapping("/getSpeaker.do")
		public String getUser(int id, Model model) {

			Speaker speaker=speakerService.selectOne(id);		
			//Subject subject=subjectService.selectOne(Integer.valueOf(course.getSubject_id()));
			model.addAttribute("Speaker", speakerService.selectOne(id));
			//model.addAttribute("Subject", subject);
			return "SpeakerEdit";
		}

		//�༭�󷵻ؿγ̽���
		@RequestMapping("/updateSpeaker.do")
		public ModelAndView UpdateUser(Model model, Speaker speaker) {

			speakerService.update(speaker);

			ModelAndView mav = new ModelAndView("redirect:/SpeakerShow.do");
			return mav;

		}
		
		

}
