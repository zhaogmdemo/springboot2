package com.example.SpringBootVideo.model;

public class Course {
	private Integer id;
	private String courseTitle;
	private String courseDesc;
	private String subjectId;
	
	public Course() {
		super();
	}

	public Course(Integer id, String courseTitle, String courseDesc, String subjectId) {
		super();
		this.id = id;
		this.courseTitle = courseTitle;
		this.courseDesc = courseDesc;
		this.subjectId = subjectId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseTitle=" + courseTitle + ", courseDesc=" + courseDesc + ", subjectId="
				+ subjectId + "]";
	}
	

	
	

}
