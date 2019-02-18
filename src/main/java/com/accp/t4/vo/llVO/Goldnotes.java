package com.accp.t4.vo.llVO;

import java.util.Date;

public class Goldnotes {
	private Integer recordID;
	private Integer userID;
	private Integer acquisitionMode;
	private Date recordDate;
	private String recordDescribe;
	private double recordInAndOut;
	private Integer auditStatus;
	public Integer getRecordID() {
		return recordID;
	}
	public void setRecordID(Integer recordID) {
		this.recordID = recordID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getAcquisitionMode() {
		return acquisitionMode;
	}
	public void setAcquisitionMode(Integer acquisitionMode) {
		this.acquisitionMode = acquisitionMode;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
	public String getRecordDescribe() {
		return recordDescribe;
	}
	public void setRecordDescribe(String recordDescribe) {
		this.recordDescribe = recordDescribe;
	}
	public double getRecordInAndOut() {
		return recordInAndOut;
	}
	public void setRecordInAndOut(double recordInAndOut) {
		this.recordInAndOut = recordInAndOut;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	public Goldnotes() {
		super();
	}
	
}
