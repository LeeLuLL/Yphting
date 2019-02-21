package com.accp.t4.entity.wxxEntity;

/**
 * 身份住址
 * @author dell
 */
public class Sharea {
	public Sharea() {
		super();
	}
	
	public Sharea(int areaID, int pId, String name, String mergerName, int level) {
		super();
		this.areaID = areaID;
		this.pId = pId;
		this.name = name;
		this.mergerName = mergerName;
		this.level = level;
	}
	
	private int areaID; //地址编号
	private int pId; //父级编号
	private String name; //地址名称
	private String mergerName; //地址全称
	private int level; //地址层级
	
	public int getAreaID() {
		return areaID;
	}
	public void setAreaID(int areaID) {
		this.areaID = areaID;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMergerName() {
		return mergerName;
	}
	public void setMergerName(String mergerName) {
		this.mergerName = mergerName;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Sharea [areaID=" + areaID + ", pId=" + pId + ", name=" + name + ", mergerName=" + mergerName
				+ ", level=" + level + "]";
	}
}
