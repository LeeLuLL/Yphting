package com.accp.t4.biz.llBiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.t4.dao.llDao.IGRZXDao;
import com.accp.t4.vo.llVO.EvaluationVo;
import com.accp.t4.vo.llVO.Goldnotes;
import com.accp.t4.vo.llVO.Integral;
import com.accp.t4.vo.llVO.OrderVO;
import com.accp.t4.vo.llVO.Refund;
import com.accp.t4.vo.llVO.UserVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class GRZXBiz {
	@Autowired
	private IGRZXDao dao;
	/**
	 * 查询用户
	 * @param userId
	 * @return
	 */
	public UserVo selectUser(Integer userId) {
		return dao.selectUser(userId);
	}
	/**
	 * 查询预订服务
	 * @param num
	 * @param userId
	 * @return
	 */
	public PageInfo<OrderVO> selectOrder(Integer num,Integer userId){
		PageHelper.startPage(num, 4);
		return new PageInfo<OrderVO>(dao.selectOrder(userId));
	}
	/**
	 * 查询金币流
	 * @param num
	 * @param userId
	 * @return
	 */
	public PageInfo<Goldnotes> selectMoney(Integer num,Integer userId){
		PageHelper.startPage(num, 4);
		return new PageInfo<Goldnotes>(dao.selectMoney(userId));
	}
	/**
	 * 查询积分记录
	 * @param num
	 * @param userId
	 * @return
	 */
	public PageInfo<Integral> selectJiFen(Integer num,Integer userId){
		PageHelper.startPage(num, 4);
		return new PageInfo<Integral>(dao.selectJiFen(userId));
	}
	/**
	 * 我的退款
	 * @param num
	 * @param userId
	 * @return
	 */
	public PageInfo<Refund> selectRefund(Integer num,Integer userId){
		PageHelper.startPage(num, 4);
		return new PageInfo<Refund>(dao.selectRefunds(userId));
	}
	/**
	 * 我的评价
	 * @param num
	 * @param userId
	 * @return
	 */
	public PageInfo<EvaluationVo> selectEvaluation(Integer num,Integer userId){
		PageHelper.startPage(num, 4);
		return new PageInfo<EvaluationVo>(dao.selectEvaluation(userId));
	}
}
