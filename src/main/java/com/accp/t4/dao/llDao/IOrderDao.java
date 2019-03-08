package com.accp.t4.dao.llDao;

import org.apache.ibatis.annotations.Param;

import com.accp.t4.entity.llEntity.Evaluationservice;
import com.accp.t4.entity.llEntity.Goldnotes;
import com.accp.t4.entity.llEntity.Orders;
import com.accp.t4.entity.llEntity.Refund;

public interface IOrderDao {
	/**
	 * 修改订单
	 * @param order
	 * @return
	 */
	public int updateOrder(@Param("order") Orders order);
	/**
	 * 添加金币记录
	 * @param goldnotes
	 * @return
	 */
	public int addGoldnotes(@Param("goldnotes") Goldnotes goldnotes);
	/**
	 * 修改用户金币
	 * @param money
	 * @param userId
	 * @return
	 */
	public int updateUserMoney(@Param("money") double money,@Param("userId") Integer userId);
	/**
	 * 添加退款
	 * @param refund
	 * @return
	 */
	public int addRefund(@Param("refund")Refund refund);
	/**
	 * 添加评价
	 * @param evaluate
	 * @return
	 */
	public int saveEvaluate(@Param("evaluate")Evaluationservice evaluate);
	/**
	 * 修改金币记录状态
	 * @param recordId
	 * @param auditStatus
	 * @return
	 */
	public int updateGoldnotes(@Param("recordId")Integer recordId,@Param("auditStatus")Integer auditStatus);
	/**
	 * 获得金币记录表最新记录的Id
	 * @return
	 */
	public int getGoldnotesId();
	
}
