package com.accp.t4.entity.wxxEntity;

/**
 * 服务类别
 * @author dell
 */
public class ServiceType {
	public ServiceType() {
		super();
	}
	
	public ServiceType(int sTid, int stPid, String stName, int sort, int display, int operationTime, int confirmTime,
			int violatedNumber, int proportion, int toExamine, String advertisement) {
		super();
		this.sTid = sTid;
		this.stPid = stPid;
		this.stName = stName;
		this.sort = sort;
		this.display = display;
		this.operationTime = operationTime;
		this.confirmTime = confirmTime;
		this.violatedNumber = violatedNumber;
		this.proportion = proportion;
		this.toExamine = toExamine;
		this.advertisement = advertisement;
	}
	
	private int sTid; //服务类别编号
	private int stPid; //夫级编号
	private String stName; //服务名称
	private int sort; //排序
	private int display; //是否显示
	private int operationTime; //未操作时间
	private int confirmTime; //自动确认时间
	private int violatedNumber; //服务违约天数
	private int proportion; //违约金比例
	private int toExamine; //是否审核
	private String advertisement; //广告图片地址
	
	public int getsTid() {
		return sTid;
	}
	public void setsTid(int sTid) {
		this.sTid = sTid;
	}
	public int getStPid() {
		return stPid;
	}
	public void setStPid(int stPid) {
		this.stPid = stPid;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getDisplay() {
		return display;
	}
	public void setDisplay(int display) {
		this.display = display;
	}
	public int getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(int operationTime) {
		this.operationTime = operationTime;
	}
	public int getConfirmTime() {
		return confirmTime;
	}
	public void setConfirmTime(int confirmTime) {
		this.confirmTime = confirmTime;
	}
	public int getViolatedNumber() {
		return violatedNumber;
	}
	public void setViolatedNumber(int violatedNumber) {
		this.violatedNumber = violatedNumber;
	}
	public int getProportion() {
		return proportion;
	}
	public void setProportion(int proportion) {
		this.proportion = proportion;
	}
	public int getToExamine() {
		return toExamine;
	}
	public void setToExamine(int toExamine) {
		this.toExamine = toExamine;
	}
	public String getAdvertisement() {
		return advertisement;
	}
	public void setAdvertisement(String advertisement) {
		this.advertisement = advertisement;
	}

	@Override
	public String toString() {
		return "ServiceType [sTid=" + sTid + ", stPid=" + stPid + ", stName=" + stName + ", sort=" + sort + ", display="
				+ display + ", operationTime=" + operationTime + ", confirmTime=" + confirmTime + ", violatedNumber="
				+ violatedNumber + ", proportion=" + proportion + ", toExamine=" + toExamine + ", advertisement="
				+ advertisement + "]";
	}
}
