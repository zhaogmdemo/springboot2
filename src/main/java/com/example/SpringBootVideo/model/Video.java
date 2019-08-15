package com.example.SpringBootVideo.model;

import java.io.Serializable;

public class Video implements Serializable{
	private Integer videoId;
	private String title;
	private String detail;
	private Integer time;
	private Integer speakerId;
	private Integer courseId;
	private String videoUrl;
	private String imageUrl;
	private Integer playNum;
	private Speaker speaker;
	private Course course;
	
	
	
	public Video() {
		super();
	}



	public Video(Integer videoId, String title, String detail, Integer time, Integer speakerId, Integer courseId,
			String videoUrl, String imageUrl, Integer playNum, Speaker speaker, Course course) {
		super();
		this.videoId = videoId;
		this.title = title;
		this.detail = detail;
		this.time = time;
		this.speakerId = speakerId;
		this.courseId = courseId;
		this.videoUrl = videoUrl;
		this.imageUrl = imageUrl;
		this.playNum = playNum;
		this.speaker = speaker;
		this.course = course;
	}



	public Integer getVideoId() {
		return videoId;
	}



	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDetail() {
		return detail;
	}



	public void setDetail(String detail) {
		this.detail = detail;
	}



	public Integer getTime() {
		return time;
	}



	public void setTime(Integer time) {
		this.time = time;
	}



	public Integer getSpeakerId() {
		return speakerId;
	}



	public void setSpeakerId(Integer speakerId) {
		this.speakerId = speakerId;
	}



	public Integer getCourseId() {
		return courseId;
	}



	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}



	public String getVideoUrl() {
		return videoUrl;
	}



	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	public Integer getPlayNum() {
		return playNum;
	}



	public void setPlayNum(Integer playNum) {
		this.playNum = playNum;
	}



	public Speaker getSpeaker() {
		return speaker;
	}



	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}



	public Course getCourse() {
		return course;
	}



	public void setCourse(Course course) {
		this.course = course;
	}



	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", title=" + title + ", detail=" + detail + ", time=" + time
				+ ", speakerId=" + speakerId + ", courseId=" + courseId + ", videoUrl=" + videoUrl + ", imageUrl="
				+ imageUrl + ", playNum=" + playNum + ", speaker=" + speaker + ", course=" + course + "]";
	}


	
	
	
	

}
