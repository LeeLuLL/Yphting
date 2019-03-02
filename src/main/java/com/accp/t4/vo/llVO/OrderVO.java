package com.accp.t4.vo.llVO;

import java.util.Date;

public class OrderVO {
	private String orderID;
	private Integer userID;
	private String userName;
	private Integer serviceID;
	private Integer merchantID;		//商家Id
	private String merchantName;	//商家名称
	private Integer businessState;
	private Date orderTime;
	private Date paymentTime;
	private String stName;
	private double totalPrice;
	private Integer population;
	private Integer number;
	private double smallPlan;
	private Integer orderStatus;
	private String serviceCoverImg;
	private String serviceFuTitle;
	private String serviceTitle;
	private Integer servicePrice;
	private Integer filesatus;
	private Integer commentstatus;
	private Integer refundstatus;
	private String shopName;
	private Date receiptTime;
	private Date provideServicesTime;
	private Date completeTime;
	
	private Date scheduledStartTime;
	private Date scheduledEndTime;
	
	private Integer stid;
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getServiceID() {
		return serviceID;
	}
	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}
	public Integer getMerchantID() {
		return merchantID;
	}
	public void setMerchantID(Integer merchantID) {
		this.merchantID = merchantID;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public Integer getBusinessState() {
		return businessState;
	}
	public void setBusinessState(Integer businessState) {
		this.businessState = businessState;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Date getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public double getSmallPlan() {
		return smallPlan;
	}
	public void setSmallPlan(double smallPlan) {
		this.smallPlan = smallPlan;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public String getServiceCoverImg() {
		return serviceCoverImg;
	}
	public void setServiceCoverImg(String serviceCoverImg) {
		this.serviceCoverImg = serviceCoverImg;
	}
	
	public String getServiceFuTitle() {
		return serviceFuTitle;
	}
	public void setServiceFuTitle(String serviceFuTitle) {
		this.serviceFuTitle = serviceFuTitle;
	}
	public String getServiceTitle() {
		return serviceTitle;
	}
	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}
	
	public double getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(Integer servicePrice) {
		this.servicePrice = servicePrice;
	}
	
	public Integer getFilesatus() {
		return filesatus;
	}
	public void setFilesatus(Integer filesatus) {
		this.filesatus = filesatus;
	}
	public Integer getCommentstatus() {
		return commentstatus;
	}
	public void setCommentstatus(Integer commentstatus) {
		this.commentstatus = commentstatus;
	}
	
	public Integer getRefundstatus() {
		return refundstatus;
	}
	public void setRefundstatus(Integer refundstatus) {
		this.refundstatus = refundstatus;
	}
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public Date getReceiptTime() {
		return receiptTime;
	}
	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}
	public Date getProvideServicesTime() {
		return provideServicesTime;
	}
	public void setProvideServicesTime(Date provideServicesTime) {
		this.provideServicesTime = provideServicesTime;
	}
	public Date getCompleteTime() {
		return completeTime;
	}
	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}
	public OrderVO() {
		super();
	}
	
	public Date getScheduledStartTime() {
		return scheduledStartTime;
	}
	public void setScheduledStartTime(Date scheduledStartTime) {
		this.scheduledStartTime = scheduledStartTime;
	}
	public Date getScheduledEndTime() {
		return scheduledEndTime;
	}
	public void setScheduledEndTime(Date scheduledEndTime) {
		this.scheduledEndTime = scheduledEndTime;
	}
	
	public Integer getStid() {
		return stid;
	}
	public void setStid(Integer stid) {
		this.stid = stid;
	}
	@Override
	public String toString() {
		return "OrderVO [orderID=" + orderID + ", userID=" + userID + ", userName=" + userName + ", serviceID="
				+ serviceID + ", merchantID=" + merchantID + ", merchantName=" + merchantName + ", businessState="
				+ businessState + ", orderTime=" + orderTime + ", paymentTime=" + paymentTime + ", stName=" + stName
				+ ", totalPrice=" + totalPrice + ", population=" + population + ", number=" + number + ", smallPlan="
				+ smallPlan + ", orderStatus=" + orderStatus + ", serviceCoverImg=" + serviceCoverImg
				+ ", serviceFuTitle=" + serviceFuTitle + ", serviceTitle=" + serviceTitle + ", servicePrice="
				+ servicePrice + ", filesatus=" + filesatus + ", commentstatus=" + commentstatus + ", refundstatus="
				+ refundstatus + ", shopName=" + shopName + ", receiptTime=" + receiptTime + ", provideServicesTime="
				+ provideServicesTime + ", completeTime=" + completeTime + "]";
	}
	
}
