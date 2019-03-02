package com.accp.t4.vo.llVO;

import com.accp.t4.entity.llEntity.Appraisalapply;
import com.accp.t4.entity.llEntity.Servicetype;
import com.accp.t4.entity.llEntity.User;

public class AppraisalapplyVO extends Appraisalapply{

	private User user;
	
	private Servicetype st;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Servicetype getSt() {
		return st;
	}

	public void setSt(Servicetype st) {
		this.st = st;
	} 
	
}
