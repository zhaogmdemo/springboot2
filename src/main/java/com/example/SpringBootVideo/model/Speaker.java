package com.example.SpringBootVideo.model;

import java.io.Serializable;

public class Speaker implements Serializable{
	private Integer id;
	private String speakerName;
	private String speakerDesc;
	private String speakerJob;
	private String pirUrl;
	
	public Speaker() {
		super();
	}

	public Speaker(Integer id, String speakerName, String speakerDesc, String speakerJob, String pirUrl) {
		super();
		this.id = id;
		this.speakerName = speakerName;
		this.speakerDesc = speakerDesc;
		this.speakerJob = speakerJob;
		this.pirUrl = pirUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSpeakerName() {
		return speakerName;
	}

	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}

	public String getSpeakerDesc() {
		return speakerDesc;
	}

	public void setSpeakerDesc(String speakerDesc) {
		this.speakerDesc = speakerDesc;
	}

	public String getSpeakerJob() {
		return speakerJob;
	}

	public void setSpeakerJob(String speakerJob) {
		this.speakerJob = speakerJob;
	}

	public String getPirUrl() {
		return pirUrl;
	}

	public void setPirUrl(String pirUrl) {
		this.pirUrl = pirUrl;
	}

	@Override
	public String toString() {
		return "Speaker [id=" + id + ", speakerName=" + speakerName + ", speakerDesc=" + speakerDesc + ", speakerJob="
				+ speakerJob + ", pirUrl=" + pirUrl + "]";
	}
	
	

	
	
	
	
	
}
