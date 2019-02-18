package com.accp.t4.vo.llVO;
/**
 * 退款
 * @author Administrator
 *
 */

import java.util.Date;

public class Refund {
	private Integer refundID;
	private String orderID;
	private String serviceTitle;
	private double applyRefundMoney;
	private double ActualRefundMoney;
	private Date applicationTime;
	private Integer refundstatus;
	private String userImgPath;
	private String userName;
	public Integer getRefundID() {
		return refundID;
	}
	public void setRefundID(Integer refundID) {
		this.refundID = refundID;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public double getApplyRefundMoney() {
		return applyRefundMoney;
	}
	public void setApplyRefundMoney(double applyRefundMoney) {
		this.applyRefundMoney = applyRefundMoney;
	}
	public double getActualRefundMoney() {
		return ActualRefundMoney;
	}
	public void setActualRefundMoney(double actualRefundMoney) {
		ActualRefundMoney = actualRefundMoney;
	}
	public Date getApplicationTime() {
		return applicationTime;
	}
	public void setApplicationTime(Date applicationTime) {
		this.applicationTime = applicationTime;
	}
	public Integer getRefundstatus() {
		return refundstatus;
	}
	public void setRefundstatus(Integer refundstatus) {
		this.refundstatus = refundstatus;
	}
	public String getUserImgPath() {
		return userImgPath;
	}
	public void setUserImgPath(String userImgPath) {
		this.userImgPath = userImgPath;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getServiceTitle() {
		return serviceTitle;
	}
	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}
	public Refund() {
		super();
	}
	
}
