package com.accp.t4.entity.wxxEntity;

/**
 * 擅长专业
 * @author dell
 */
public class MajorType {
	public MajorType() {
		super();
	}
	
	public MajorType(int majorID, int category, String majorName) {
		super();
		this.majorID = majorID;
		this.category = category;
		this.majorName = majorName;
	}
	
	private int majorID; //专业编号
	private int category; //类别编号
	private String majorName; //专业名称
	
	public int getMajorID() {
		return majorID;
	}
	public void setMajorID(int majorID) {
		this.majorID = majorID;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getMajorName() {
		return majorName;
	}
	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	@Override
	public String toString() {
		return "MajorType [majorID=" + majorID + ", category=" + category + ", majorName=" + majorName + "]";
	}
}
