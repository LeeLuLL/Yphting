package com.accp.t4.entity.lgbEntity;

public class Forummanagement {

	private Integer fmid;

    private Integer pid;

    private Integer sort;

    private String fmname;

    private Boolean auditstatus;

    private Boolean giftintegral;

    private Integer adminid;

    private Integer servicecopies;
    
    

	public Forummanagement() {
		super();
	}

	public Forummanagement(Integer fmid, Integer pid, Integer sort, String fmname, Boolean auditstatus,
			Boolean giftintegral, Integer adminid, Integer servicecopies) {
		super();
		this.fmid = fmid;
		this.pid = pid;
		this.sort = sort;
		this.fmname = fmname;
		this.auditstatus = auditstatus;
		this.giftintegral = giftintegral;
		this.adminid = adminid;
		this.servicecopies = servicecopies;
	}

	public Integer getFmid() {
		return fmid;
	}

	public void setFmid(Integer fmid) {
		this.fmid = fmid;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getFmname() {
		return fmname;
	}

	public void setFmname(String fmname) {
		this.fmname = fmname;
	}

	public Boolean getAuditstatus() {
		return auditstatus;
	}

	public void setAuditstatus(Boolean auditstatus) {
		this.auditstatus = auditstatus;
	}

	public Boolean getGiftintegral() {
		return giftintegral;
	}

	public void setGiftintegral(Boolean giftintegral) {
		this.giftintegral = giftintegral;
	}

	public Integer getAdminid() {
		return adminid;
	}

	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}

	public Integer getServicecopies() {
		return servicecopies;
	}

	public void setServicecopies(Integer servicecopies) {
		this.servicecopies = servicecopies;
	}

	@Override
	public String toString() {
		return "Forummanagement [fmid=" + fmid + ", pid=" + pid + ", sort=" + sort + ", fmname=" + fmname
				+ ", auditstatus=" + auditstatus + ", giftintegral=" + giftintegral + ", adminid=" + adminid
				+ ", servicecopies=" + servicecopies + "]";
	}
    
	
    
}
