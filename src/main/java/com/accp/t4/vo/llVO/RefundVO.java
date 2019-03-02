package com.accp.t4.vo.llVO;

import com.accp.t4.entity.llEntity.Orders;
import com.accp.t4.entity.llEntity.Services;
import com.accp.t4.entity.llEntity.User;

public class RefundVO extends com.accp.t4.entity.llEntity.Refund{
	
	private Orders orders;
	
	private User user;

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "RefundVO [getRefundreason()=" + getRefundreason() + ", getRefundexplain()=" + getRefundexplain()
				+ ", getBusinessremarks()=" + getBusinessremarks() + ", getAdminremarks()=" + getAdminremarks()
				+ ", getRefundid()=" + getRefundid() + ", getPoint()=" + getPoint() + ", getOrderid()=" + getOrderid()
				+ ", getUserid()=" + getUserid() + ", getRefundimg()=" + getRefundimg() + ", getApplyrefundmoney()="
				+ getApplyrefundmoney() + ", getActualrefundmoney()=" + getActualrefundmoney()
				+ ", getApplicationtime()=" + getApplicationtime() + ", getAudittime()=" + getAudittime()
				+ ", getAuditstatus()=" + getAuditstatus() + ", getAdmintime()=" + getAdmintime()
				+ ", getAdminstatus()=" + getAdminstatus() + ", toString()=" + super.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + "]";
	}

	
}
