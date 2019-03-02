package com.accp.t4.biz.llBiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.t4.dao.llDao.IGRZXDao;
import com.accp.t4.dao.llDao.IOrderDao;
import com.accp.t4.dao.llDao.ISJZXDao;
import com.accp.t4.entity.llEntity.Appraisalapply;
import com.accp.t4.entity.llEntity.Goldnotes;
import com.accp.t4.entity.llEntity.Orders;
import com.accp.t4.entity.llEntity.Services;
import com.accp.t4.vo.llVO.AppraisalapplyVO;
import com.accp.t4.vo.llVO.OrderVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class SJZXBiz {
	@Autowired
	private IOrderDao orderDao;
	@Autowired
	private IGRZXDao grzxDao;
	@Autowired
	private ISJZXDao sjzxDao;
	
	/**
	 * 商家中心修改订单状态
	 * @param order
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int udpateOrder(Orders order) {
		if(order.getOrderstatus()==6) {		//商家取消订单、退换金币给用户
			OrderVO orderVo=grzxDao.getOrder(order.getOrderid());
			Goldnotes goldnotes = new Goldnotes(orderVo.getUserID(), 3, "商家取消服务"+order.getOrderid(), (float)orderVo.getSmallPlan(), 2);
			orderDao.addGoldnotes(goldnotes);
			orderDao.updateUserMoney(orderVo.getSmallPlan(), orderVo.getUserID());
		}
		return orderDao.updateOrder(order);
	}
	/**
	 * 商家发布的服务
	 * @param userId
	 * @param num
	 * @return
	 */
	public PageInfo<Services> selectServices(Integer userId,Integer num){
		PageHelper.startPage(num, 4);
		return new PageInfo<Services>(sjzxDao.selectServices(userId));
	}
	
	/**
	 * 鉴定申请
	 * @param userId
	 * @return
	 */
	public List<AppraisalapplyVO> getApply(Integer userId,Integer oneid,Integer twoid){
		return sjzxDao.selectAppraisalapplys(userId,oneid,twoid);
	}
	/**
	 * 添加鉴定申请
	 * @param apply
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public int addAppraisaApply(Appraisalapply apply) {
		return sjzxDao.addApply(apply);
	}
	
}
