package com.accp.t4.biz.llBiz;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.t4.dao.llDao.IOrderDao;
import com.accp.t4.entity.llEntity.Evaluationservice;
import com.accp.t4.entity.llEntity.Goldnotes;
import com.accp.t4.entity.llEntity.Orders;
import com.accp.t4.entity.llEntity.Refund;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class OrderBiz {
	@Autowired
	private IOrderDao orderDao;
	/**
	 * 支付订单
	 * @param money
	 * @param userId
	 * @param order
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int updateOrder(double money,Integer userId,Orders order) {
		Goldnotes goldnotes = new Goldnotes(userId, 1, "支付订单："+order.getOrderid(),(float)-money, 2);
		orderDao.addGoldnotes(goldnotes);  //添加金币记录
		orderDao.updateUserMoney(-money, userId); //修改用户金币余额
		return orderDao.updateOrder(order);  //修改订单信息
	}
	/**
	 * 取消订单
	 * @param order
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int cancelOrder(Orders order) {
		return orderDao.updateOrder(order);
	}
	/**
	 * 确认订单完成
	 * @param order
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int orderOk(double money,Integer userId,Orders order) {
		System.out.println(userId+"---------------------");
		Goldnotes goldnotes=new Goldnotes(userId, 2, "订单收益："+order.getOrderid(), (float)(money*0.9), 2);
		orderDao.addGoldnotes(goldnotes);
		System.out.println(goldnotes);
		orderDao.updateUserMoney(money*0.9, userId);
		return orderDao.updateOrder(order);
	}
	/**
	 * 评价完成
	 * @param evaluate
	 * @param order
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int evaluateOK(Evaluationservice evaluate,Orders order) {
		orderDao.updateOrder(order);
		return orderDao.saveEvaluate(evaluate);
	}
	
	/**
	 * 确认退款
	 * @param reund
	 * @param order
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int refundOK(Refund refund,Orders order) {
		orderDao.addRefund(refund);
		return orderDao.updateOrder(order);
	}
	/**
	 * 修改订单信息
	 * @param order
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int updateOrderDetail(Orders order) {
		return orderDao.updateOrder(order);
	}
	/**
	 * 添加金币记录
	 * @param goldnotes
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int addGoldnotes(Goldnotes goldnotes) {
		return orderDao.addGoldnotes(goldnotes);
	}
	/**
	 * 修改用户金币
	 * @param money
	 * @param userId
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int updateUserMoney(double money,Integer userId) {
		return orderDao.updateUserMoney(money, userId);
	}
	
}
