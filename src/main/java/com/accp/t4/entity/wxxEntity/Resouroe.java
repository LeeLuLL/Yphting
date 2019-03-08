package com.accp.t4.entity.wxxEntity;

public class Resouroe {
	public Resouroe() {
		super();
	}
	
	public Resouroe(int resouroeId, String resouroueName) {
		super();
		this.resouroeId = resouroeId;
		this.resouroeName = resouroueName;
	}
	
	private int resouroeId;
	private String resouroeName;
	
	public int getResouroeId() {
		return resouroeId;
	}
	public void setResouroeId(int resouroeId) {
		this.resouroeId = resouroeId;
	}
	public String getResouroeName() {
		return resouroeName;
	}
	public void setResouroueName(String resouroeName) {
		this.resouroeName = resouroeName;
	}
}
