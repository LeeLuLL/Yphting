package com.accp.t4.vo.llVO;

import com.accp.t4.entity.llEntity.Services;
import com.accp.t4.entity.llEntity.User;

public class ServicesVo extends Services{
 
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
   
	
}
