package com.accp.t4.vo.llVO;

import com.accp.t4.entity.llEntity.Orders;
import com.accp.t4.entity.llEntity.Services;

public class OrdersVo extends Orders{
	
	private Services services;

	public Services getServices() {
		return services;
	}

	public void setServices(Services services) {
		this.services = services;
	}
	
	
	
}
