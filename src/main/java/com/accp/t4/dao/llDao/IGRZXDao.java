package com.accp.t4.dao.llDao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.accp.t4.entity.llEntity.Services;
import com.accp.t4.vo.llVO.EvaluationVo;
import com.accp.t4.vo.llVO.Goldnotes;
import com.accp.t4.vo.llVO.Integral;
import com.accp.t4.vo.llVO.MerchantVo;
import com.accp.t4.vo.llVO.OrderVO;

public interface IGRZXDao {
	
	/**
	 * 查询预订的订单
	 * @param userId  用户Id
	 * @param date	最近预订 
	 * @param orderId 订单Id -------查询详情
	 * @return
	 */
	public List<OrderVO> selectOrder(@Param("userId")Integer userId,@Param("data") String date,@Param("merchantID") Integer merchantID);
	/**
	 * 查询单个订单
	 * @param orderId
	 * @return
	 */
	public OrderVO getOrder(@Param("orderId") String orderId);
	
	/**
	 * 查询金币
	 * @param userId
	 * @return
	 */
	public List<Goldnotes> selectMoney(@Param("userId")Integer userId);
	/**
	 * 查询积分记录
	 * @param userId
	 * @return
	 */
	public List<Integral> selectJiFen(@Param("userId")Integer userId);
	/**
	 * 我的退款
	 * @param userId
	 * @return
	 */
	//public List<Refund> selectRefunds(@Param("userId")Integer userId);
	/**
	 * 查询退款详情
	 * @param refundId
	 * @return
	 */
	//public Refund selectRefundDetail(@Param("refundId") Integer refundId);
	
	/**
	 * 我的评价
	 * @param userId
	 * @return
	 */
	public List<EvaluationVo> selectEvaluation(@Param("userId")Integer userId);
	/**
	 * 收藏服务
	 * @param userId
	 * @return
	 */
	public List<Services> selectServiceCollection(@Param("userId")Integer userId);
	/**
	 * 收藏商家
	 * @param userId
	 * @return
	 */
	public List<MerchantVo> selectMerchantCollection(@Param("userId")Integer userId);
	
	
	
}
