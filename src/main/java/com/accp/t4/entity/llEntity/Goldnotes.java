package com.accp.t4.entity.llEntity;

import java.util.Date;

public class Goldnotes {
    private Integer recordid;

    private Integer userid;

    private Integer acquisitionmode;

    private Date recorddate;

    private String recorddescribe;

    private Float recordinandout;

    private Integer auditstatus;

    public Integer getRecordid() {
        return recordid;
    }

    public void setRecordid(Integer recordid) {
        this.recordid = recordid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getAcquisitionmode() {
        return acquisitionmode;
    }

    public void setAcquisitionmode(Integer acquisitionmode) {
        this.acquisitionmode = acquisitionmode;
    }

    public Date getRecorddate() {
        return recorddate;
    }

    public void setRecorddate(Date recorddate) {
        this.recorddate = recorddate;
    }

    public String getRecorddescribe() {
        return recorddescribe;
    }

    public void setRecorddescribe(String recorddescribe) {
        this.recorddescribe = recorddescribe == null ? null : recorddescribe.trim();
    }

    public Float getRecordinandout() {
        return recordinandout;
    }

    public void setRecordinandout(Float recordinandout) {
        this.recordinandout = recordinandout;
    }

    public Integer getAuditstatus() {
        return auditstatus;
    }

    public void setAuditstatus(Integer auditstatus) {
        this.auditstatus = auditstatus;
    }

	public Goldnotes() {
		super();
	}

	public Goldnotes(Integer userid, Integer acquisitionmode, String recorddescribe,
			Float recordinandout, Integer auditstatus) {
		super();
		this.userid = userid;
		this.acquisitionmode = acquisitionmode;
		this.recorddescribe = recorddescribe;
		this.recordinandout = recordinandout;
		this.auditstatus = auditstatus;
	}

	@Override
	public String toString() {
		return "Goldnotes [recordid=" + recordid + ", userid=" + userid + ", acquisitionmode=" + acquisitionmode
				+ ", recorddate=" + recorddate + ", recorddescribe=" + recorddescribe + ", recordinandout="
				+ recordinandout + ", auditstatus=" + auditstatus + "]";
	}
    
}