package com.accp.t4.entity.wxxEntity;

/**
 * 系统设置
 * @author dell
 */
public class System {
	public System() {
		super();
	}
	
	public System(int sysID, int exchangeRate, int charge, int signIn, int postIntegral, int track, int releaseBeauty,
			int logisticMin, int logisticMinSeller, int logisticWeight, int logisticPrice, float bond, int videoSize,
			int closeorderdays, int receivedays, int refunddays, int refundconfirmdays, int shopFreeStatus,
			int freeTime) {
		super();
		this.sysID = sysID;
		this.exchangeRate = exchangeRate;
		this.charge = charge;
		this.signIn = signIn;
		this.postIntegral = postIntegral;
		this.track = track;
		this.releaseBeauty = releaseBeauty;
		this.logisticMin = logisticMin;
		this.logisticMinSeller = logisticMinSeller;
		this.logisticWeight = logisticWeight;
		this.logisticPrice = logisticPrice;
		this.bond = bond;
		this.videoSize = videoSize;
		this.closeorderdays = closeorderdays;
		this.receivedays = receivedays;
		this.refunddays = refunddays;
		this.refundconfirmdays = refundconfirmdays;
		this.shopFreeStatus = shopFreeStatus;
		this.freeTime = freeTime;
	}
	
	private int sysID; //系统配置编号
	private int exchangeRate; //金币汇率
	private int charge; //收费比例
	private int signIn; //签到获得积分
	private int postIntegral; //发帖获得积分
	private int track; //跟帖获得积分
	private int releaseBeauty; //发布美妆获得积分
	private int logisticMin; //普通会员物流重量
	private int logisticMinSeller; //商家会员物流重量
	private int logisticWeight; //上门取货物流重量
	private int logisticPrice; //单价/kg
	private float bond; //保证金
	private int videoSize; //视频大小/MB
	private int closeorderdays; //订单下单未付款
	private int receivedays; //订单完成后，n天后自动确认服务，0为不自动确认服务
	private int refunddays; //订单完成后，用户在n天内可以发起退款申请，设置0天不允许完成订单退款
	private int refundconfirmdays; //用户发起退款申请后，订单退款申请几天后自动确认
	private int shopFreeStatus; //是否开启店铺免费体验模式
	private int freeTime; //店铺免费体验月数
	
	public int getSysID() {
		return sysID;
	}
	public void setSysID(int sysID) {
		this.sysID = sysID;
	}
	public int getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(int exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	public int getSignIn() {
		return signIn;
	}
	public void setSignIn(int signIn) {
		this.signIn = signIn;
	}
	public int getPostIntegral() {
		return postIntegral;
	}
	public void setPostIntegral(int postIntegral) {
		this.postIntegral = postIntegral;
	}
	public int getTrack() {
		return track;
	}
	public void setTrack(int track) {
		this.track = track;
	}
	public int getReleaseBeauty() {
		return releaseBeauty;
	}
	public void setReleaseBeauty(int releaseBeauty) {
		this.releaseBeauty = releaseBeauty;
	}
	public int getLogisticMin() {
		return logisticMin;
	}
	public void setLogisticMin(int logisticMin) {
		this.logisticMin = logisticMin;
	}
	public int getLogisticMinSeller() {
		return logisticMinSeller;
	}
	public void setLogisticMinSeller(int logisticMinSeller) {
		this.logisticMinSeller = logisticMinSeller;
	}
	public int getLogisticWeight() {
		return logisticWeight;
	}
	public void setLogisticWeight(int logisticWeight) {
		this.logisticWeight = logisticWeight;
	}
	public int getLogisticPrice() {
		return logisticPrice;
	}
	public void setLogisticPrice(int logisticPrice) {
		this.logisticPrice = logisticPrice;
	}
	public float getBond() {
		return bond;
	}
	public void setBond(float bond) {
		this.bond = bond;
	}
	public int getVideoSize() {
		return videoSize;
	}
	public void setVideoSize(int videoSize) {
		this.videoSize = videoSize;
	}
	public int getCloseorderdays() {
		return closeorderdays;
	}
	public void setCloseorderdays(int closeorderdays) {
		this.closeorderdays = closeorderdays;
	}
	public int getReceivedays() {
		return receivedays;
	}
	public void setReceivedays(int receivedays) {
		this.receivedays = receivedays;
	}
	public int getRefunddays() {
		return refunddays;
	}
	public void setRefunddays(int refunddays) {
		this.refunddays = refunddays;
	}
	public int getRefundconfirmdays() {
		return refundconfirmdays;
	}
	public void setRefundconfirmdays(int refundconfirmdays) {
		this.refundconfirmdays = refundconfirmdays;
	}
	public int getShopFreeStatus() {
		return shopFreeStatus;
	}
	public void setShopFreeStatus(int shopFreeStatus) {
		this.shopFreeStatus = shopFreeStatus;
	}
	public int getFreeTime() {
		return freeTime;
	}
	public void setFreeTime(int freeTime) {
		this.freeTime = freeTime;
	}
}
