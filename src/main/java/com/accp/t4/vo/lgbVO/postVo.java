package com.accp.t4.vo.lgbVO;

import java.util.Date;

public class postVo {

	
	private Integer postid;
	private Integer fmid;
	private String fmname;
	private String title;
	private Date releasetime;
	private Integer auditstatus;
	private String adminopinion;
	private Integer recommend;
	private String content;
	private Integer operatingState;
	
	
	public postVo() {
		super();
	}


	public postVo(Integer postid, Integer fmid, String fmname, String title, Date releasetime, Integer auditstatus,
			String adminopinion, Integer recommend, String content, Integer operatingState) {
		super();
		this.postid = postid;
		this.fmid = fmid;
		this.fmname = fmname;
		this.title = title;
		this.releasetime = releasetime;
		this.auditstatus = auditstatus;
		this.adminopinion = adminopinion;
		this.recommend = recommend;
		this.content = content;
		this.operatingState = operatingState;
	}


	public Integer getPostid() {
		return postid;
	}


	public void setPostid(Integer postid) {
		this.postid = postid;
	}


	public Integer getFmid() {
		return fmid;
	}


	public void setFmid(Integer fmid) {
		this.fmid = fmid;
	}


	public String getFmname() {
		return fmname;
	}


	public void setFmname(String fmname) {
		this.fmname = fmname;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Date getReleasetime() {
		return releasetime;
	}


	public void setReleasetime(Date releasetime) {
		this.releasetime = releasetime;
	}


	public Integer getAuditstatus() {
		return auditstatus;
	}


	public void setAuditstatus(Integer auditstatus) {
		this.auditstatus = auditstatus;
	}


	public String getAdminopinion() {
		return adminopinion;
	}


	public void setAdminopinion(String adminopinion) {
		this.adminopinion = adminopinion;
	}


	public Integer getRecommend() {
		return recommend;
	}


	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Integer getOperatingState() {
		return operatingState;
	}


	public void setOperatingState(Integer operatingState) {
		this.operatingState = operatingState;
	}


	@Override
	public String toString() {
		return "postVo [postid=" + postid + ", fmid=" + fmid + ", fmname=" + fmname + ", title=" + title
				+ ", releasetime=" + releasetime + ", auditstatus=" + auditstatus + ", adminopinion=" + adminopinion
				+ ", recommend=" + recommend + ", content=" + content + ", operatingState=" + operatingState + "]";
	}
	
	
	
}
