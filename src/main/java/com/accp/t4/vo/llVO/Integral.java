package com.accp.t4.vo.llVO;
/**
 * 积分
 * @author Administrator
 *
 */

import java.util.Date;

public class Integral {
	private Integer IRID;
	private Integer userID;
	private Date IRDate;
	private String IRDescribe;
	private Integer recordInAndOut;
	private Integer integralID;
	private Integer auditStatus;
	public Integer getIRID() {
		return IRID;
	}
	public void setIRID(Integer iRID) {
		IRID = iRID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Date getIRDate() {
		return IRDate;
	}
	public void setIRDate(Date iRDate) {
		IRDate = iRDate;
	}
	public String getIRDescribe() {
		return IRDescribe;
	}
	public void setIRDescribe(String iRDescribe) {
		IRDescribe = iRDescribe;
	}
	public Integer getRecordInAndOut() {
		return recordInAndOut;
	}
	public void setRecordInAndOut(Integer recordInAndOut) {
		this.recordInAndOut = recordInAndOut;
	}
	public Integer getIntegralID() {
		return integralID;
	}
	public void setIntegralID(Integer integralID) {
		this.integralID = integralID;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}
	public Integral() {
		super();
	}
	
	
}
