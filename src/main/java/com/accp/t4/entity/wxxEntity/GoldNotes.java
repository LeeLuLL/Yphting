package com.accp.t4.entity.wxxEntity;

import java.sql.Timestamp;

/**
 * 金币流向记录
 * @author dell
 */
public class GoldNotes {
	public GoldNotes() {
		super();
	}
	
	public GoldNotes(int userID, String recordDescribe, Float recordInAndOut, int auditStatus) {
		super();
		this.userID = userID;
		this.recordDescribe = recordDescribe;
		this.recordInAndOut = recordInAndOut;
		this.auditStatus = auditStatus;
	}

	public GoldNotes(int recordID, int userID, int acquisitionMode, Timestamp recordDate, String recordDescribe,
			Float recordInAndOut, int auditStatus) {
		super();
		this.recordID = recordID;
		this.userID = userID;
		this.acquisitionMode = acquisitionMode;
		this.recordDate = recordDate;
		this.recordDescribe = recordDescribe;
		this.recordInAndOut = recordInAndOut;
		this.auditStatus = auditStatus;
	}
	
	private int recordID; //金币流向操作记录id
	private int userID; //用户编号
	private int acquisitionMode; //流通方式
	private Timestamp recordDate; //记录日期
	private String recordDescribe; //记录描述
	private Float recordInAndOut; //记录收入、支出
	private int auditStatus; //审核状态
	
	public int getRecordID() {
		return recordID;
	}
	public void setRecordID(int recordID) {
		this.recordID = recordID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getAcquisitionMode() {
		return acquisitionMode;
	}
	public void setAcquisitionMode(int acquisitionMode) {
		this.acquisitionMode = acquisitionMode;
	}
	public Timestamp getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Timestamp recordDate) {
		this.recordDate = recordDate;
	}
	public String getRecordDescribe() {
		return recordDescribe;
	}
	public void setRecordDescribe(String recordDescribe) {
		this.recordDescribe = recordDescribe;
	}
	public Float getRecordInAndOut() {
		return recordInAndOut;
	}
	public void setRecordInAndOut(Float recordInAndOut) {
		this.recordInAndOut = recordInAndOut;
	}
	public int getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(int auditStatus) {
		this.auditStatus = auditStatus;
	}
}
